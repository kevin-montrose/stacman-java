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
    private String key;
    private HashMap<String, Date> backoffUntil = new HashMap<String, Date>();

    private int apiTimeoutMs;
    public int getApiTimeoutMs() { return apiTimeoutMs; }
    public void setApiTimeoutMs(int timeout) { apiTimeoutMs = timeout; }

    private int maxSimultaneousRequests;
    public int getMaxSimultaneousRequests() { return maxSimultaneousRequests; }
    public void setMaxSimultaneousRequests(int maxRequests) { maxSimultaneousRequests = maxRequests; }

    private boolean respectBackoffs;
    public boolean getRespectBackoffs() { return respectBackoffs; }
    public void setRespectBackoffs(boolean doRespectBackoffs) { respectBackoffs = doRespectBackoffs; }

    public final AccessTokenMethods accessTokens = new AccessTokenMethods(this);

    private final AtomicInteger activeRequests = new AtomicInteger();

    private ExecutorService executor = Executors.newFixedThreadPool(30);

    public StacManClient() { this(null); }
    public StacManClient(String appKey) {
        key = appKey;
        setApiTimeoutMs(5000);
        setMaxSimultaneousRequests(10);
        setRespectBackoffs(true);
    }

    <T> Future<StacManResponse<T>> createApiTask(ApiUrlBuilder ub, String backoffKey) {
        ub.addParameter("key", key);

        final String urlFinal = ub.toString();

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

                        InputStreamReader is = new InputStreamReader(in);
                        StringBuilder sb=new StringBuilder();
                        BufferedReader br = new BufferedReader(is);
                        String read = br.readLine();

                        while(read != null) {
                            sb.append(read);
                            read = br.readLine();
                        }

                        try
                        {
                            Wrapper<T> wrapper =  parseApiResponse(sb.toString());

                            return new StacManResponse<T>(wrapper, null);
                        }catch(Exception e){
                            return new StacManResponse<T>(null, e);
                        }
                    }
                };

        return executor.submit(background);
    }

    private <T> Wrapper<T> parseApiResponse(String json) {
        Gson gson = new Gson();

        Wrapper<T> x = gson.fromJson(json, (new Wrapper<T>()).getClass());

        return x;
    }

    static <T> void validateEnumerable(Iterable<T> values, String paramName) {
        if (values == null)
            throw new IllegalArgumentException(paramName);

        if (!values.iterator().hasNext())
            throw new IllegalArgumentException(paramName + " cannot be empty");
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
}
