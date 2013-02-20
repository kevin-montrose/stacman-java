package com.stackexchange.stacman;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/20/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BadgeSort implements ISortType {
    Rank("badgerank"),
    Name("string");

    public static final BadgeSort Default = Rank;

    private final String type;

    public boolean isInteger(){ return false; }
    public boolean isDate(){ return false; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return false; }
    public boolean isBadgeRank() { return type == "badgerank"; }

    BadgeSort(String type){
        this.type = type;
    }
}