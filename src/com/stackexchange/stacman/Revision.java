package com.stackexchange.stacman;

import java.util.Date;
import java.util.UUID;

public final class Revision {
    private String body;
    public String getBody() {return body;}

    private String comment;
    public String getComment(){return comment;}

    private long creation_date;
    public Date getCreationDate(){return new Date(creation_date);}

    private boolean is_rollback;
    public boolean getIsRollback() {return is_rollback; }

    private String last_body;
    public String getLastBody(){return last_body;}

    private String[] last_tags;
    public String[] getLastTags(){return last_tags;}

    private String last_title;
    public String getLastTitle(){return last_title; }

    private int post_id;
    public int getPostId(){return post_id;}

    private String post_type;
    public PostType getPostType(){return StacManClient.parseEnum(PostType.class, post_type); }

    private String revision_guid;
    public UUID getRevisionGuid(){return UUID.fromString(revision_guid);}

    private int revision_number;
    public int getRevisionNumber() {return revision_number; }

    private String revision_type;
    public RevisionType getRevisionType(){return StacManClient.parseEnum(RevisionType.class, revision_type); }

    private boolean set_community_wiki;
    public boolean getSetCommunityWiki(){return set_community_wiki;}

    private String[] tags;
    public String[] getTags(){return tags;}

    private String title;
    public String getTitle(){return title;}

    private ShallowUser user;
    public ShallowUser getUser(){return user;}
}
