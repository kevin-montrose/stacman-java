package com.stackexchange.stacman;

import java.util.Date;

/**
 * StacMan InboxItem, corresponding to Stack Exchange API v2's inbox_item type
 * http://api.stackexchange.com/docs/types/inbox-item
 */
public final class InboxItem {
    private Integer answer_id;
    public Integer getAnswerId() { return answer_id; }

    private String body;
    public String getBody() { return body; }

    private Integer comment_id;
    public Integer getCommentId() { return comment_id; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private boolean is_unread;
    public boolean  getIsUnread() { return is_unread; }

    private String item_type;
    public ItemType getItemType() { return StacManClient.parseEnum(ItemType.class, item_type); }

    private String link;
    public String getLink() { return link; }

    private Integer question_id;
    public Integer getQuestionId() { return question_id; }

    private Site site;
    public Site getSite() { return site; }

    private String title;
    public String getTitle() { return title; }
}
