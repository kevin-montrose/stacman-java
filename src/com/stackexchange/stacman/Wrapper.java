package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * StacMan Wrapper, corresponding to Stack Exchange API v2's common wrapper type
 * http://api.stackexchange.com/docs/wrapper
 */
public final class Wrapper<T> implements Serializable {
    private Integer backoff;
    public Integer getBackoff() { return backoff; }

    private Integer error_id;
    public Integer getErrorId() { return error_id; }

    private String error_message;
    public String getErrorMessage(){ return error_message; }

    private String error_name;
    public String getErrorName() { return error_name; }

    private boolean has_more;
    public boolean getHasMore(){ return has_more; }

    private T[] items;

    private List<T> itemsList;
    public List<T> getItems() {
        if(itemsList == null && items != null){
            itemsList = Arrays.asList(items);
        }

        return itemsList;
    }

    private int page;
    public int getPage(){ return page; }

    private int page_size;
    public int getPageSize(){ return page_size; }

    private int quota_max;
    public int getQuotaMax() { return quota_max; }

    private int quota_remaining;
    public int getQuotaRemaining() { return quota_remaining; }

    private int total;
    public int getTotal(){ return total; }

    private String type;
    public String getType() { return type; }

    public Wrapper(){}
}
