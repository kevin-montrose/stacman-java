package com.stackexchange.stacman;

import java.util.Date;

public final class UserTimeline {
    private Integer badge_id;
    public Integer getBadgeId() { return badge_id; }

    private Integer comment_id;
    public Integer getCommentId() { return comment_id; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private String detail;
    public String getDetail() { return detail; }

    private String link;
    public String getLink() { return link; }

    private Integer post_id;
    public Integer getPostId() { return post_id; }

    private String post_type;
    public PostType getPostType() { return StacManClient.parseEnum(PostType.class, post_type); }

    private Integer suggested_edit_id;
    public Integer getSuggestedEditId() { return suggested_edit_id; }

    private String timeline_type;
    public UserTimelineType getTimelineType() { return StacManClient.parseEnum(UserTimelineType.class, timeline_type); }

    private String title;
    public String getTitle() { return title; }

    private int user_id;
    public int getUserId() { return user_id; }
}
