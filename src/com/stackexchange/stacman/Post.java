package com.stackexchange.stacman;

import java.util.Date;

public final class Post {
    private String body;
    public String getBody() { return body; }

    private Comment[] comments;
    public Comment[] getComments(){return comments; }

    private long creation_date;
    public Date getCreationDate(){return new Date(creation_date* 1000); }

    private int down_vote_count;
    public int getDownVoteCount(){return down_vote_count; }

    private long last_activity_date;
    public Date getLastActivityDate(){return new Date(last_activity_date* 1000);}

    private Long last_edit_date;
    public Date getLastEditDate(){return last_edit_date != null ? new Date(last_edit_date* 1000) : null;}

    private ShallowUser owner;
    public ShallowUser getOwner(){return owner;}

    private int post_id;
    public int getPostId(){return post_id; }

    private String post_type;
    public PostType getPostType(){return StacManClient.parseEnum(PostType.class, post_type); }

    private int score;
    public int getScore(){return score;}

    private int up_vote_count;
    public int getUpVoteCount(){return up_vote_count;}
}
