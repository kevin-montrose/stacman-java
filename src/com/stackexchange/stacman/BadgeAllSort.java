package com.stackexchange.stacman;

public enum BadgeAllSort implements ISortType {
    Rank("badgerank"),
    Name("string"),
    Type("badgetype");

    public static final BadgeAllSort Default = Rank;

    private final String type;

    public boolean isInteger(){ return false; }
    public boolean isDate(){ return false; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return false; }
    public boolean isBadgeType() { return type == "badgetype"; }
    public boolean isBadgeRank() { return type == "badgerank"; }

    BadgeAllSort(String type){
        this.type = type;
    }
}
