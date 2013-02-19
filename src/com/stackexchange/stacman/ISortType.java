package com.stackexchange.stacman;

interface ISortType<T> {
    public boolean isInteger();
    public boolean isDate();
    public boolean isString();

    public  T getDefault();
}
