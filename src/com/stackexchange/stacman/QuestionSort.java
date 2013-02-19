package com.stackexchange.stacman;

public enum QuestionSort implements ISortType{
    Activity("date"),
    Creation("date"),
    Votes("integer");

    public static final QuestionSort Default = Activity;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return false; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    QuestionSort(String type) {
        this.type = type;
    }
}
