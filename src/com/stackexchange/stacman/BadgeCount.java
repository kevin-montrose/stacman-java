package com.stackexchange.stacman;

/**
 * StacMan BadgeCount, corresponding to Stack Exchange API v2's badge_count type
 * http://api.stackexchange.com/docs/types/badge-count
 */
public final class BadgeCount {
    private int bronze;
    public int getBronze(){ return bronze;}

    private int gold;
    public int getGold() { return gold; }

    private int silver;
    public int getSilver() { return silver; }
}
