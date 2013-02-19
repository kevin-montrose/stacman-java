package com.stackexchange.stacman;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.impl.encoding.IDLJavaSerializationInputStream;
import com.sun.javafx.image.impl.IntArgbPre;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.zip.GZIPInputStream;

/**
 * Client for Stack Exchange API v2
 */
public final class StacManClient {
    public final AccessTokenMethods accessTokens = new AccessTokenMethods(this);
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

    private ExecutorService executor = Executors.newFixedThreadPool(30);

    public StacManClient() { this(null); }
    public StacManClient(String appKey) {
        key = appKey;
        setApiTimeoutMs(5000);
        setMaxSimultaneousRequests(10);
        setRespectBackoffs(true);
    }

    <T> Future<StacManResponse<T>> createApiTask(Type type, ApiUrlBuilder ub, String backoffKey) {
        ub.addParameter("key", key);

        final String urlFinal = ub.toString();
        final Type typeFinal = type;

        Callable<StacManResponse<T>> background =
                new Callable<StacManResponse<T>>() {
                    @Override
                    public StacManResponse<T> call() throws Exception {
                        URL fetchFrom = new URL(urlFinal);

                        URLConnection con = fetchFrom.openConnection();
                        con.setRequestProperty("User-Agent", "StacMan Java");
                        con.setRequestProperty("Accept-Encoding", "gzip");

                        con.connect();

                        InputStream in = con.getInputStream();

                        GZIPInputStream gzip = new GZIPInputStream(in);

                        InputStreamReader is = new InputStreamReader(gzip);
                        StringBuilder sb=new StringBuilder();
                        BufferedReader br = new BufferedReader(is);
                        String read = br.readLine();

                        while(read != null) {
                            sb.append(read);
                            read = br.readLine();
                        }

                        gzip.close();

                        try
                        {
                            Wrapper<T> wrapper =  parseApiResponse(sb.toString(), typeFinal);

                            return new StacManResponse<T>(wrapper, null);
                        }catch(Exception e){
                            return new StacManResponse<T>(null, e);
                        }
                    }
                };

        return executor.submit(background);
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

    static void validateString(String value, String paramName)
    {
        if (value == null)
            throw new IllegalArgumentException(paramName);

        if (value.equals(""))
            throw new IllegalArgumentException(paramName + " cannot be empty");
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
    }

    static String join(String joiner, Iterable<String> parts) {
        String ret = "";

        boolean first = true;
        for(String p : parts) {
            if(!first) ret += joiner;

            ret += p;
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
}
