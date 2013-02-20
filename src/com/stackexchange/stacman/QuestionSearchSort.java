package com.stackexchange.stacman;

public enum QuestionSearchSort implements ISortType {
    Activity("date"),
    Creation("date"),
    Votes("integer"),
    Relevance("none");

    public static final QuestionSearchSort Default = Activity;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return type == "none"; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    QuestionSearchSort(String type){
        this.type = type;
    }
}