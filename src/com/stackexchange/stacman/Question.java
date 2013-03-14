package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

/**
 * StacMan Question, corresponding to Stack Exchange API v2's question type
 * http://api.stackexchange.com/docs/types/question
 */
public final class Question implements Serializable {
    private Integer accepted_answer_id;
    public Integer getAcceptedAnswerId() { return accepted_answer_id; }

    private int answer_count;
    public int getAnswerCount() { return answer_count; }

    private Answer[] answers;
    public Answer[] getAnswers(){ return answers; }

    private String body;
    public String getBody() { return body; }

    private Integer bounty_amount;
    public Integer getBountyAmount() { return bounty_amount; }

    private Long bounty_closes_date;
    public Date getBountyClosesDate() { return bounty_closes_date != null ? new Date(bounty_closes_date* 1000) : null;}

    private Long closed_date;
    public Date getClosedDate() { return closed_date != null ? new Date(closed_date* 1000) : null; }

    private String closed_reason;
    public String getClosedReason() { return closed_reason; }

    private Comment[] comments;
    public Comment[] getComments() { return comments; }

    private Long community_owned_date;
    public Date getCommunityOwnerDate() { return community_owned_date != null ? new Date(community_owned_date* 1000) : null; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private int down_vote_count;
    public int getDownVoteCount() { return down_vote_count; }

    private int favorite_count;
    public int getFavoriteCount(){ return favorite_count; }

    private boolean is_answered;
    public boolean getIsAnswered() { return is_answered; }

    private long last_activity_date;
    public Date getLastActivityDate() { return new Date(last_activity_date* 1000); }

    private Long last_edit_date;
    public Date getLastEditDate(){ return last_edit_date != null ? new Date(last_edit_date* 1000) : null ;}

    private String link;
    public String getLink() { return link; }

    private Long locked_date;
    public Date getLockedDate(){ return locked_date != null ? new Date(locked_date* 1000) : null; }

    private MigrationInfo migrated_from;
    public MigrationInfo getMigratedFrom() { return migrated_from; }

    private MigrationInfo migrated_to;
    public MigrationInfo getMigratedTo() { return migrated_to; }

    private ShallowUser owner;
    public ShallowUser getOwner;

    private Long protected_date;
    public Date getProtectedDate() { return protected_date != null ? new Date(protected_date* 1000) : null; }

    private int question_id;
    public int getQuestionId(){ return question_id; }

    private int score;
    public int getScore(){ return score; }

    private String[] tags;
    public String[] getTags(){ return tags; }

    private String title;
    public String getTitle(){ return title; }

    private int up_vote_count;
    public int getUpVoteCount(){ return up_vote_count; }

    private int view_count;
    public int getViewCount(){ return view_count; }
}
