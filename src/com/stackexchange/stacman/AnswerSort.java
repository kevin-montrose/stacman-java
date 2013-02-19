package com.stackexchange.stacman;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/19/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public enum AnswerSort implements ISortType {
    Activity("date"),
    Creation("date"),
    Votes("integer");

    private final String type;

    public boolean isInteger(){ return type == "integer"; }
    public boolean isDate(){ return type == "date"; }
    public boolean isString(){ return type == "string"; }
    public boolean isNone() { return type == "none"; }

    AnswerSort(String type){
        this.type = type;
    }
}
