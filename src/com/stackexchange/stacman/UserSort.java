package com.stackexchange.stacman;

public enum UserSort implements ISortType<UserSort> {
    Reputation("integer"),
    Creation("date"),
    Name("string"),
    Modified("date");

    public static final UserSort Default = Reputation;

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return false; }

    UserSort(String type) {
        this.type = type;
    }
}
