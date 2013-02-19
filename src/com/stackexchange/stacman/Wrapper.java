package com.stackexchange.stacman;

import java.util.ArrayList;

/**
 * StacMan Wrapper, corresponding to Stack Exchange API v2's common wrapper type
 * http://api.stackexchange.com/docs/wrapper
 */
class Wrapper<T> {
    private Integer backoff;
    public Integer getBackoff() { return backoff; }
    public void setBackoff(Integer b) { backoff = b; }

    private Integer errorId;
    public Integer getErrorId() { return errorId; }
    public void setErrorId(Integer e) { errorId = e; }

    private String errorMessage;
    public String getErrorMessage(){ return errorMessage; }
    public void setErrorMessage(String msg) { errorMessage = msg; }

    private String errorName;
    public String getErrorName() { return errorName; }
    public void setErrorName(String name) { errorName = name; }

    private boolean hasMore;
    public boolean getHasMore(){ return hasMore; }
    public void setHasMore(boolean h) { hasMore = h; }

    private T[] items;
    public T[] getItems() { return items;  }
    public void setItems(T[] i) { items =i; }

    private int page;
    public int getPage(){ return page; }
    public void setPage(int p) { page = p; }

    private int pageSize;
    public int getPageSize(){ return pageSize; }
    public void setPageSize(int p) { pageSize = p; }

    private int quotaMax;
    public int getQuotaMax() { return quotaMax; }
    public void setQuotaMax(int m) { quotaMax = m; }

    private int quotaRemaining;
    public int getQuotaRemaining() { return quotaRemaining; }
    public void setQuotaRemaining(int q) { quotaRemaining = q; }

    private int total;
    public int getTotal(){ return total; }
    public void setTotal(int t) { total = t; }

    private String type;
    public String getType() { return type; }

    public Wrapper(){}
}
