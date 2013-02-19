package com.stackexchange.stacman;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

final class Types {
    public static final Type User = new TypeToken<Wrapper<User>>() {}.getType();
    public static final Type AccessToken = new TypeToken<Wrapper<AccessToken>>() {}.getType();
    public static final Type Question = new TypeToken<Wrapper<Question>>() {}.getType();
}
