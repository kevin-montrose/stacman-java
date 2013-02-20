package com.stackexchange.stacman;

import com.stackexchange.stacman.ShallowUser;

/**
 * StacMan Badge, corresponding to Stack Exchange API v2's badge type
 * http://api.stackexchange.com/docs/types/badge
 */
public final class Badge {
    private int award_count;
    public int getAwardCount(){return award_count;}

    private int badge_id;
    public int getBadgeId(){return badge_id;}

    private String badge_type;
    public BadgeType getBadgeType() { return StacManClient.parseEnum(BadgeType.class, badge_type); }

    private String description;
    public String getDescription() { return description; }

    private String link;
    public String getLink() { return link; }

    private String name;
    public String getName() { return name; }

    private String rank;
    public BadgeRank getRank() { return StacManClient.parseEnum(BadgeRank.class, rank); }

    private ShallowUser user;
    private ShallowUser getUser() { return user; }
}
