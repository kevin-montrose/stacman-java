package com.stackexchange.stacman;

import java.io.Serializable;

/**
 * StacMan ClosedDetails, corresponding to Stack Exchange API v2's closed_details type
 * http://api.stackexchange.com/docs/types/closed-details
 */
public class ClosedDetails implements Serializable {
    private ShallowUser[] by_users;
    public ShallowUser[] getUsers() {
        return by_users;
    }

    private String description;
    public String getDescription() {
        return description;
    }

    private boolean on_hold;
    public boolean getOnHold() {
        return on_hold;
    }

    private String reason;
    public String getReason() {
        return reason;
    }

    private OriginalQuestion[] original_questions;
    public OriginalQuestion[] getOriginalQuestions() { return original_questions; }

}
