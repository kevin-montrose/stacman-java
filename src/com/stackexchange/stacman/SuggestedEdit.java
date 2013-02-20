package com.stackexchange.stacman;

import java.util.Date;

public final class SuggestedEdit {
    private Long approval_date;
    public Date getApprovalDate() { return approval_date != null ? new Date(approval_date) : null; }

    private String body;
    public String getBody() { return body; }

    private String comment;
    public String getComment() { return comment; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date); }

    private int post_id;
    public int getPostId() { return post_id; }

    private String post_type;
    public PostType getPostType() { return PostType.valueOf(post_type); }

    private ShallowUser proposing_user;
    public ShallowUser getProposingUser() { return proposing_user; }

    private Long rejection_date;
    public Date getRejectionDate() { return rejection_date != null ? new Date(rejection_date): null;}

    private int suggested_edit_id;
    public int getSuggestedEditId() { return suggested_edit_id; }

    private String[] tags;
    public String[] getTags() { return tags; }

    private String title;
    public String getTitle() { return title; }
}
