package com.stackexchange.stacman;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/19/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public enum QuestionAllSort implements ISortType {
    Activity("date"),
    Votes("integer"),
    Creation("date"),
    Hot("none"),
    Week("none"),
    Month("none");

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return type == "none"; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    QuestionAllSort(String type){
        this.type = type;
    }
}
