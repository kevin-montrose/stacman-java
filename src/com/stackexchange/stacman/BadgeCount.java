package com.stackexchange.stacman;

import java.io.Serializable;

/**
 * StacMan BadgeCount, corresponding to Stack Exchange API v2's badge_count type
 * http://api.stackexchange.com/docs/types/badge-count
 */
public final class BadgeCount implements Serializable {
    private Integer bronze;
    public Integer getBronze(){ return bronze;}

    private Integer gold;
    public Integer getGold() { return gold; }

    private Integer silver;
    public Integer getSilver() { return silver; }
}
