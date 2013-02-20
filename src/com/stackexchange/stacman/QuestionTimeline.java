package com.stackexchange.stacman;

import java.util.Date;
import java.util.UUID;

public final class QuestionTimeline {
    private Integer comment_id;
    public Integer getCommentId() { return comment_id;}

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date); }

    private Integer down_vote_count;
    public Integer getDownVoteCount() { return down_vote_count; }

    private ShallowUser owner;
    public ShallowUser getOwner() { return owner; }

    private Integer post_id;
    public Integer getPostId() { return post_id; }

    private int question_id;
    public int getQuestionId() { return question_id; }

    private String revision_guid;
    public UUID getRevisionGuid() { return UUID.fromString(revision_guid); }

    private String timeline_type;
    public QuestionTimelineType getTimelineType() { return StacManClient.parseEnum(QuestionTimelineType.class, timeline_type); }

    private Integer up_vote_count;
    public Integer getUpVoteCount() { return up_vote_count; }

    private ShallowUser user;
    public ShallowUser getUser() { return user; }
}
