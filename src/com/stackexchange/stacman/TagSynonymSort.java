package com.stackexchange.stacman;

public enum TagSynonymSort implements ISortType {
    Creation("date"),
    Applied("integer"),
    Activity("date");

    public static final TagSynonymSort Default = Creation;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return false; }
    public boolean isNone() { return false;}
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    TagSynonymSort(String type){
        this.type = type;
    }
}
