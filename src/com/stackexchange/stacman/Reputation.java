package com.stackexchange.stacman;

import java.util.Date;

/**
 * StacMan Reputation, corresponding to Stack Exchange API v2's reputation type
 * http://api.stackexchange.com/docs/types/reputation
 */
public final class Reputation {
    private String link;
    public String getLink(){return link;}

    private long on_date;
    public Date getOnDate() { return new Date(on_date); }

    private int post_id;
    public int getPostId() { return post_id; }

    private String post_type;
    public PostType getPostType() { return StacManClient.parseEnum(PostType.class, post_type); }

    private int reputation_change;
    public int getReputationChange() { return reputation_change; }

    private String title;
    public String getTitle(){return title;}

    private int user_id;
    public int getUserId() { return user_id; }

    private String vote_type;
    public VoteType getVoteType() { return StacManClient.parseEnum(VoteType.class, vote_type); }
}
