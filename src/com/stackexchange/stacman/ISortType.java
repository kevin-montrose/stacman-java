package com.stackexchange.stacman;

interface ISortType {
    public boolean isInteger();
    public boolean isDate();
    public boolean isString();
    public boolean isNone();
    public boolean isBadgeRank();
    public boolean isBadgeType();
}
