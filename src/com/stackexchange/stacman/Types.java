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
    public static final Type Reputation =  new TypeToken<Wrapper<Reputation>>() {}.getType();
    public static final Type SuggestedEdit =  new TypeToken<Wrapper<SuggestedEdit>>() {}.getType();
    public static final Type Tag =  new TypeToken<Wrapper<Tag>>() {}.getType();
    public static final Type UserTimeline =  new TypeToken<Wrapper<UserTimeline>>() {}.getType();
    public static final Type TopTag =  new TypeToken<Wrapper<TopTag>>() {}.getType();
    public static final Type NetworkUser =  new TypeToken<Wrapper<NetworkUser>>() {}.getType();
    public static final Type QuestionTimeline =  new TypeToken<Wrapper<QuestionTimeline>>() {}.getType();
    public static final Type Error =  new TypeToken<Wrapper<Error>>() {}.getType();
    public static final Type Event =  new TypeToken<Wrapper<Event>>() {}.getType();
    public static final Type Filter =  new TypeToken<Wrapper<Filter>>() {}.getType();
    public static final Type Info =  new TypeToken<Wrapper<Info>>() {}.getType();
    public static final Type Post =  new TypeToken<Wrapper<Post>>() {}.getType();
    public static final Type Revision =  new TypeToken<Wrapper<Revision>>() {}.getType();
    public static final Type Site =  new TypeToken<Wrapper<Site>>() {}.getType();
    public static final Type TagSynonym =  new TypeToken<Wrapper<TagSynonym>>() {}.getType();
    public static final Type TagScore =  new TypeToken<Wrapper<TagScore>>() {}.getType();
    public static final Type TagWiki =  new TypeToken<Wrapper<TagWiki>>() {}.getType();
}
