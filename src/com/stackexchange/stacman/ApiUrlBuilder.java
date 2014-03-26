package com.stackexchange.stacman;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;

public final class ApiUrlBuilder {
    private final String baseUrl;
    private final HashMap<String, String> queryStringParameters;

    public ApiUrlBuilder(String fullUrl) {
        baseUrl = fullUrl;
        queryStringParameters = new HashMap<String, String>();
    }

    public ApiUrlBuilder(String relativeUrl, boolean useHttps) {
        baseUrl =
                String.format(
                        "%1$s://api.stackexchange.com/2.2%2$s%3$s",
                        "https",
                        relativeUrl.startsWith("/") ? "" : "/",
                        relativeUrl
                );
        queryStringParameters = new HashMap<String, String>();
    }

    public String getParameters() {
        String ret = "";

        if(queryStringParameters.size() > 0) {
            String tail ="";
            for(String key : queryStringParameters.keySet()) {
                if(tail.length() > 0) {
                    tail += "&";
                }
                try{
                    tail+= URLEncoder.encode(key, "UTF-8") + "="+URLEncoder.encode(queryStringParameters.get(key), "UTF-8");
                }catch(Throwable t){
                    throw new RuntimeException(t);
                }
            }

            ret += tail;
        }

        return ret;
    }

    public void addParameter(String name, Object value){
        if(value != null) {
            queryStringParameters.put(name, value.toString());
        }
    }

    public void addParameter(String name, Date dt) {
        if(dt != null) {
            addParameter(name, dt.getTime() / 1000);
        }
    }

    public void addParameter(String name, Iterable<String> values) {
        if(values != null && values.iterator().hasNext()){
            String val = "";
            for(String v : values) {
                if(val.length() > 0) val += ";";
                val += v;
            }

            addParameter(name, val);
        }
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public String getBaseUrlWithParameters()
    {
        return baseUrl + "?" + getParameters();

    }
}
