package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

/**
 * StacMan Answer, corresponding to Stack Exchange API v2's answer type
 * http://api.stackexchange.com/docs/types/answer
 */
public final class Answer implements Serializable {
    private int answer_id;
    public int getAnswerId() { return answer_id; }

    private String body;
    public String getBody() { return body; }

    private Comment[] comments;
    public Comment[] getComments() { return comments; }

    private Long community_owned_date;
    public Date getCommunityOwnedDate() { return community_owned_date != null ? new Date(community_owned_date * 1000) : null; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private int down_vote_count;
    public int getDownVoteCount() { return down_vote_count; }

    private boolean is_accepted;
    public boolean  getIsAccepted(){ return is_accepted; }

    private long last_activity_date;
    public Date getLastActivityDate() { return new Date(last_activity_date* 1000); }

    private Long last_edit_date;
    public Date getLastEditDate() { return last_edit_date != null ? new Date(last_edit_date* 1000) : null;}

    private String link;
    public String getLink(){ return link; }

    private Long locked_date;
    public Date getLockedDate(){ return locked_date != null ? new Date(locked_date* 1000) : null; }

    private ShallowUser owner;
    public ShallowUser getOwner() { return owner; }

    private int question_id;
    public int getQuestionId() { return question_id; }

    private int score;
    public int getScore() { return score; }

    private String title;
    public String getTitle(){ return title; }

    private int up_vote_count;
    public int getUpVoteCount(){ return up_vote_count; }
}
