package com.stackexchange.stacman;

import java.util.Date;

/**
 * StacMan Comment, corresponding to Stack Exchange API v2's comment type
 * http://api.stackexchange.com/docs/types/comment
 */
public final class Comment {
    private String body;
    public String getBody() { return body; }

    private int comment_id;
    public int getCommentId() { return comment_id; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date); }

    private boolean edited;
    public boolean getEdited() { return edited; }

    private String link;
    public String getLink() { return link; }

    private ShallowUser owner;
    public ShallowUser getOwner(){ return owner;}

    private int post_id;
    public int getPostId() { return post_id; }

    private String post_type;
    public PostType getPostType() { return StacManClient.parseEnum(PostType.class, post_type);}

    private ShallowUser reply_to_user;
    public ShallowUser getReplyToUser() { return reply_to_user; }

    private int score;
    public int getScore() { return score; }
}
