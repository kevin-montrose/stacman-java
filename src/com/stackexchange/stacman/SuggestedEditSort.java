package com.stackexchange.stacman;

public enum SuggestedEditSort implements ISortType {
    Creation("date"),
    Approval("date"),
    Rejection("date");

    public static final SuggestedEditSort Default = Creation;

    private final String type;

    public boolean isInteger(){ return false; }
    public boolean isDate(){ return true; }
    public boolean isString(){ return false; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    SuggestedEditSort(String type){
        this.type = type;
    }
}
