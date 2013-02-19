package com.stackexchange.stacman;

/**
 * StacMan Privilege, corresponding to Stack Exchange API v2's privilege type
 * http://api.stackexchange.com/docs/types/privilege
 */
public final class Privilege {
    private String description;
    public String getDescription() { return description; }

    private int reputation;
    public int getReputation() { return reputation; }

    private String short_description;
    public String getShortDescription() { return short_description; }
}
