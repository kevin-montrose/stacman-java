package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents API v2.2's SearchExcerpt type
 */
public final class SearchExcerpt implements Serializable {
    private String title;
    public String getTitle() { return title; }

    private String excerpt;
    public String getExcerpt() { return excerpt; }

    private Long community_owned_date;
    public Date getCommunityOwnedDate() { return community_owned_date != null ? new Date(community_owned_date* 1000) : null; }

    private Long locked_date;
    public Date getLockedDate() { return locked_date != null ? new Date(locked_date* 1000) : null; }

    private Long creation_date;
    public Date getCreationDate() { return creation_date != null ? new Date(creation_date* 1000) : null; }

    private Long last_activity_date;
    public Date getLastActivityDate() { return last_activity_date != null ? new Date(last_activity_date* 1000) : null; }

    private ShallowUser owner;
    public ShallowUser getOwner() { return owner; }

    private ShallowUser last_activity_user;
    public ShallowUser getLastActivityUser() { return last_activity_user; }

    private Integer score;
    public Integer getScore(){ return score; }

    private String item_type;
    public SearchExcerptItemType getItemType() {return StacManClient.parseEnum(SearchExcerptItemType.class, item_type); }

    private String body;
    public String getBody() { return body; }

    private Integer question_id;
    public Integer getQuestionId() { return question_id; }

    private Boolean is_answered;
    public Boolean getIsAnswered(){ return is_answered; }

    private Integer answer_count;
    public Integer getAnswerCount() { return answer_count; }

    private String[] tags;
    public String[] getTags(){ return tags; }

    private Long closed_date;
    public Date getClosedDate() { return closed_date != null ? new Date(closed_date* 1000) : null; }

    private Integer answer_id;
    public Integer getAnswerId() { return answer_id; }

    private Boolean is_accepted;
    public Boolean getIsAccepted() { return is_accepted; }

    private String[] equivalent_tag_search;
    public String[] getEquivalentTagSearch() { return equivalent_tag_search; }

}