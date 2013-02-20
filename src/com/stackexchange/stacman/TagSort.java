package com.stackexchange.stacman;

public enum TagSort implements ISortType{
    Popular("integer"),
    Activity("date"),
    Name("string");

    public static final TagSort Default = Popular;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    TagSort(String type){
        this.type = type;
    }
}
