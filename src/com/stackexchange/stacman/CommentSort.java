package com.stackexchange.stacman;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/19/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CommentSort implements ISortType {
    Creation("date"),
    Votes("integer");

    public static final CommentSort Default = Creation;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return false; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    CommentSort(String type) {
        this.type = type;
    }
}
