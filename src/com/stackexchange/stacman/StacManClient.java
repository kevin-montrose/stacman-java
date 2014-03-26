package com.stackexchange.stacman;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import java.util.zip.GZIPInputStream;

/**
 * Client for Stack Exchange API v2
 */
public final class StacManClient {
    public final AccessTokenMethods accessTokens = new AccessTokenMethods(this);
    public final AnswerMethods answers = new AnswerMethods(this);
    public final ApplicationMethods applications = new ApplicationMethods(this);
    public final BadgeMethods badges = new BadgeMethods(this);
    public final CommentMethods comments = new CommentMethods(this);
    public final ErrorMethods errors = new ErrorMethods(this);
    public final EventMethods events = new EventMethods(this);
    public final FilterMethods filters = new FilterMethods(this);
    public final InboxMethods inbox = new InboxMethods(this);
    public final InfoMethods info = new InfoMethods(this);
    public final PostMethods posts = new PostMethods(this);
    public final PrivilegeMethods privileges = new PrivilegeMethods(this);
    public final QuestionMethods questions = new QuestionMethods(this);
    public final RevisionMethods revisions = new RevisionMethods(this);
    public final SearchMethods search = new SearchMethods(this);
    public final SiteMethods sites = new SiteMethods(this);
    public final SuggestedEditMethods suggestedEdits = new SuggestedEditMethods(this);
    public final TagMethods tags = new TagMethods(this);
    public final UserMethods users = new UserMethods(this);

    private String key;

    private int apiTimeoutMs;
    public int getApiTimeoutMs() { return apiTimeoutMs; }
    public void setApiTimeoutMs(int timeout) { apiTimeoutMs = timeout; }

    private int maxSimultaneousRequests;
    public int getMaxSimultaneousRequests() { return maxSimultaneousRequests; }
    public void setMaxSimultaneousRequests(int maxRequests) { maxSimultaneousRequests = maxRequests; }

    private boolean respectBackoffs;
    public boolean getRespectBackoffs() { return respectBackoffs; }
    public void setRespectBackoffs(boolean doRespectBackoffs) { respectBackoffs = doRespectBackoffs; }

    private RequestRunner mRequestRunner;

    private String accessToken;

    public StacManClient() { this(null, null); }

    public StacManClient(String appKey, String accessToken) {
        this(appKey, accessToken, new DefaultRequestRunner());
    }

    public StacManClient(String appKey, String accessToken, RequestRunner runner) {
        key = appKey;
        setApiTimeoutMs(5000);
        setMaxSimultaneousRequests(10);
        setRespectBackoffs(true);

        this.mRequestRunner = runner;
        this.accessToken = accessToken;
    }

    public void setAccessToken(String token) {
        accessToken = token;
    }

    public <T> Future<StacManResponse<T>> createApiTask(Type type, ApiUrlBuilder ub, String backoffKey) {
        return createApiTask(type, ub, backoffKey, false);
    }

    public static interface RequestRunner {
        abstract <T> Future<StacManResponse<T>> run(Callable<StacManResponse<T>> callable);
    }

    private static class DefaultRequestRunner implements RequestRunner {
        private ExecutorService executor = Executors.newFixedThreadPool(30);
        @Override
        public <T> Future<StacManResponse<T>> run(Callable<StacManResponse<T>> callable) {
            return executor.submit(callable);
        }
    }

    public <T> Future<StacManResponse<T>> createApiTask(Type type, ApiUrlBuilder ub, String backoffKey, final Boolean isPost) {
        ub.addParameter("key", key);

        final String urlFinal = ub.getBaseUrlWithParameters();
        final Type typeFinal = type;
        final String backoffKeyFinal = backoffKey;
        final String urlPostBody = ub.getParameters();
        final String baseUrl = ub.getBaseUrl();

        Callable<StacManResponse<T>> background =
                new Callable<StacManResponse<T>>() {
                    @Override
                    public StacManResponse<T> call() throws Exception {

                        long shouldWaitFor;
                        InputStream in = null;

                        do{
                            shouldWaitFor = ShouldWait(backoffKeyFinal);

                            if(shouldWaitFor > 0) {
                                Thread.sleep(shouldWaitFor);
                            }
                        }while(shouldWaitFor != -1);

                        URL fetchFrom;

                        if (isPost)
                            fetchFrom = new URL(baseUrl);
                        else
                            fetchFrom = new URL(urlFinal);

                        HttpURLConnection con = (HttpURLConnection) fetchFrom.openConnection();

                        con.setRequestProperty("User-Agent", "StacMan Java");
                        con.setRequestProperty("Accept-Encoding", "gzip");

                        if (isPost)
                        {
                            con.setDoOutput(true);
                            OutputStream wr = con.getOutputStream();
                            wr.write(urlPostBody.getBytes("UTF-8"));
                            wr.close();
                        }
                        int responseCode = 0;
                        try
                        {
                            responseCode = con.getResponseCode();
                        }
                        catch (Exception exception)
                        {
                            // if we didn't even get a response code, this is a network error
                            return new StacManResponse<T>(null, exception);
                        }

                        if (responseCode == HttpURLConnection.HTTP_OK)
                            in = con.getInputStream();
                        else
                            in = con.getErrorStream();

                        if ("gzip".equals(con.getContentEncoding())) {
                            in = new GZIPInputStream(in);
                        }

                        InputStreamReader is = new InputStreamReader(in);
                        StringBuilder sb=new StringBuilder();
                        BufferedReader br = new BufferedReader(is);
                        String read = br.readLine();

                        while(read != null) {
                            sb.append(read);
                            read = br.readLine();
                        }

                        in.close();

                        try
                        {
                            Wrapper<T> wrapper =  parseApiResponse(sb.toString(), typeFinal);

                            setBackoffs(wrapper, backoffKeyFinal);

                            return new StacManResponse<T>(wrapper, null);
                        } catch(Exception e){
                            return new StacManResponse<T>(null, e);
                        }
                    }
                };

        return mRequestRunner.run(background);
    }

    private int requestsOverLast5Secs = 0;
    private Date last5SecondsStarted = new Date();
    private HashMap<String, Date> backoffUntil = new HashMap<String, Date>();

    private <T> void setBackoffs(Wrapper<T> resp, String backoffKey){
        if(resp.getBackoff() != null && resp.getBackoff() > 0) {
            Date now = new Date();
            long until = now.getTime() + 1000 * resp.getBackoff();

            synchronized (backoffUntil) {
                backoffUntil.put(backoffKey, new Date(until));
            }
        }
    }

    private synchronized long ShouldWait(String backoffKey){
        Date now = new Date();

        long elapsed = now.getTime() - last5SecondsStarted.getTime();

        if(elapsed > 30000){
            requestsOverLast5Secs = 0;
            last5SecondsStarted = now;
        }

        if(requestsOverLast5Secs >= 30){
            return Math.max(30000 - elapsed, 1);
        }

        synchronized (backoffUntil){
            if(backoffUntil.containsKey(backoffKey)){
                Date until = backoffUntil.get(backoffKey);

                if(until.after(now)){
                    return until.getTime() - now.getTime();
                }
            }
        }

        requestsOverLast5Secs++;
        return -1;
    }

    private <T> Wrapper<T> parseApiResponse(String json, Type type) {
        Gson gson = new Gson();

        Wrapper<T> x = gson.fromJson(json, type);

        return x;
    }

    static <T> void validateEnumerable(Iterable<T> values, String paramName) {
        if (values == null)
            throw new IllegalArgumentException(paramName);

        if (!values.iterator().hasNext())
            throw new IllegalArgumentException(paramName + " cannot be empty");
    }

    static void validatePaging(Integer page, Integer pagesize) {
        if (page != null && page < 1)
            throw new IllegalArgumentException("page must be positive");

        if (pagesize != null && pagesize < 0)
            throw new IllegalArgumentException("pagesize cannot be negative");
    }

    public static void validateString(String value, String paramName)
    {
        if (value == null)
            throw new IllegalArgumentException(paramName);

        if (value.equals(""))
            throw new IllegalArgumentException(paramName + " cannot be empty");
    }

    static <TSort extends ISortType> void validateSortMinMax(
            TSort sort,
            Date mindate,
            Date maxdate
    )
    {
        validateSortMinMax(sort, null, null, mindate, maxdate, null, null);
    }

    static <TSort extends ISortType> void validateSortMinMax(
            TSort sort,
            Date mindate,
            Date maxdate,
            Integer min,
            Integer max
    )
    {
        validateSortMinMax(sort, min, max, mindate, maxdate, null, null);
    }

    static <TSort extends ISortType> void validateSortMinMax(
        TSort sort,
        Integer min,
        Integer max,
        Date mindate,
        Date maxdate,
        String minname,
        String maxname
    )
    {
        if(sort == null) throw new IllegalArgumentException("sort cannot be null");

        if(!sort.isDate()){
            if(mindate != null) throw new IllegalArgumentException("mindate must be null when sort is "+sort);
            if(maxdate != null) throw new IllegalArgumentException("maxdate must be null when sort is "+sort);
        }

        if(!sort.isInteger()){
            if(min != null) throw new IllegalArgumentException("min must be null when sort is "+sort);
            if(max != null) throw new IllegalArgumentException("max must be null when sort is "+sort);
        }

        if(!sort.isString()) {
            if(minname != null) throw new IllegalArgumentException("minname must be null when sort is "+sort);
            if(maxname != null) throw new IllegalArgumentException("maxname must be null when sort is "+sort);
        }

        if(sort.isNone()) {
            if(min != null) throw new IllegalArgumentException("min must be null when sort is "+sort);
            if(max != null) throw new IllegalArgumentException("max must be null when sort is "+sort);
            if(mindate != null) throw new IllegalArgumentException("mindate must be null when sort is "+sort);
            if(maxdate != null) throw new IllegalArgumentException("maxdate must be null when sort is "+sort);
            if(minname != null) throw new IllegalArgumentException("minname must be null when sort is "+sort);
            if(maxname != null) throw new IllegalArgumentException("maxname must be null when sort is "+sort);
        }
    }

    static <TSort extends ISortType> void validateSortMinMax(
            TSort sort,
            BadgeRank minrank,
            BadgeRank maxrank,
            String minname,
            String maxname
    )
    {
        validateSortMinMax(sort, minrank, maxrank, minname, maxname, null, null, null, null);
    }

    static <TSort extends ISortType> void validateSortMinMax(
            TSort sort,
            BadgeRank minrank,
            BadgeRank maxrank,
            String minname,
            String maxname,
            BadgeType mintype,
            BadgeType maxtype
    )
    {
        validateSortMinMax(sort, minrank, maxrank, minname, maxname, mintype, maxtype, null, null);
    }

    static <TSort extends ISortType> void validateSortMinMax(
            TSort sort,
            BadgeRank minrank,
            BadgeRank maxrank,
            String minname,
            String maxname,
            BadgeType mintype,
            BadgeType maxtype,
            Date mindate,
            Date maxdate
    )
    {
        if(sort == null) throw new IllegalArgumentException("sort cannot be null");

        if(!sort.isDate()){
            if(mindate != null) throw new IllegalArgumentException("mindate must be null when sort is "+sort);
            if(maxdate != null) throw new IllegalArgumentException("maxdate must be null when sort is "+sort);
        }

        if(!sort.isString()) {
            if(minname != null) throw new IllegalArgumentException("minname must be null when sort is "+sort);
            if(maxname != null) throw new IllegalArgumentException("maxname must be null when sort is "+sort);
        }

        if(!sort.isBadgeRank()) {
            if(minrank != null) throw new IllegalArgumentException("minrank must be null when sort is "+sort);
            if(maxrank != null) throw new IllegalArgumentException("maxrank must be null when sort is "+sort);
        }

        if(!sort.isBadgeType()) {
            if(mintype != null) throw new IllegalArgumentException("mintype must be null when sort is "+sort);
            if(maxtype != null) throw new IllegalArgumentException("maxtype must be null when sort is "+sort);
        }
    }

    static <T> String join(String joiner, Iterable<T> parts) {
        String ret = "";

        boolean first = true;
        for(T p : parts) {
            if(!first) ret += joiner;

            ret += p.toString();
            first = false;
        }

        return ret;
    }

    static <T> Iterable<T> toIter(T[] array) {
        ArrayList<T> asIter = new ArrayList<T>(array.length);

        for(int i = 0; i < array.length; i++) {
            asIter.add(array[i]);
        }

        return asIter;
    }

    public static <T extends Enum<T>> T parseEnum(Class<T> enumClass, String enumStr) {
        T[] vals = enumClass.getEnumConstants();

        String enumName = "";
        boolean capitalizeNext = true;


        for(int i = 0; i < enumStr.length(); i++) {
            char c = enumStr.charAt(i);
            if(capitalizeNext){
                c = Character.toUpperCase(c);
                capitalizeNext = false;
            }

            if(c == '_') {
                capitalizeNext=true;
                continue;
            }

            enumName += c;
        }

        for(int i =0; i < vals.length; i++){
            if(vals[i].toString().equals(enumName)) return vals[i];
        }

        throw new RuntimeException("Failed finding" + enumName);
    }
}
