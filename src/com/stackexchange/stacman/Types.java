package com.stackexchange.stacman;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

final class Types {
    public static final Type User = new TypeToken<Wrapper<User>>() {}.getType();
    public static final Type AccessToken = new TypeToken<Wrapper<AccessToken>>() {}.getType();
    public static final Type Question = new TypeToken<Wrapper<Question>>() {}.getType();
    public static final Type InboxItem = new TypeToken<Wrapper<InboxItem>>() {}.getType();
    public static final Type Answer = new TypeToken<Wrapper<Answer>>() {}.getType();
    public static final Type Badge =  new TypeToken<Wrapper<Badge>>() {}.getType();
    public static final Type Comment =  new TypeToken<Wrapper<Comment>>() {}.getType();
    public static final Type Privilege =  new TypeToken<Wrapper<Privilege>>() {}.getType();
}
