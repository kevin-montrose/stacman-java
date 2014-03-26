package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

/**
 * StacMan NetworkActivity, corresponding to Stack Exchange API v2.2's network_activity type
 * http://api.stackexchange.com/docs/types/network-activity
 */
public final class NetworkActivity implements Serializable {

    private int account_id;
    public int getAccountId() { return account_id; }

    private String activity_type;
    public NetworkActivityType getActivityType() { return StacManClient.parseEnum(NetworkActivityType.class, activity_type); }

    private String api_site_parameter;
    public String getApiSiteParameter() { return api_site_parameter; }

    private Integer badge_id;
    public Integer getBadgeId(){ return badge_id; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private String description;
    public String getDescription() { return description; }

    private String link;
    public String getLink(){ return link; }

    private Integer post_id;
    public Integer getPostId() { return post_id; }

    private Integer score;
    public Integer getScore(){ return score; }

    private String[] tags;
    public String[] getTags(){ return tags; }

    private String title;
    public String getTitle(){ return title; }
}
