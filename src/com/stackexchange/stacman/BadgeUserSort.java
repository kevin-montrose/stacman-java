package com.stackexchange.stacman;

/**
 * sort
 */
public enum BadgeUserSort implements ISortType {
    Rank("badgerank"),
    Name("string"),
    Type("badgetype"),
    Awarded("date");

    public static final BadgeUserSort Default = Rank;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return false; }
    public boolean isBadgeRank() { return type == "badgerank"; }
    public boolean isBadgeType() { return type == "badgetype"; }

    BadgeUserSort(String type) {
        this.type = type;
    }
}
