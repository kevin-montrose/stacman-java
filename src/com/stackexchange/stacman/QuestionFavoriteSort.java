package com.stackexchange.stacman;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/19/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public enum QuestionFavoriteSort implements ISortType {
    Activity("date"),
    Creation("date"),
    Votes("integer"),
    Added("date");

    public static final QuestionFavoriteSort Default = Activity;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return false; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return false; }

    QuestionFavoriteSort(String type) {
        this.type = type;
    }
}
