package com.stackexchange.stacman;

import java.io.Serializable;

public final class TagScore implements Serializable {
    private int post_count;
    public int getPostCount(){return post_count;}

    private int score;
    public int Score(){return score;}

    private ShallowUser user;
    public ShallowUser getUser(){return user;}
}
