package com.stackexchange.stacman;

import java.util.Date;

public final class Tag {
    private int count;
    public int getCount() { return count; }

    private boolean has_synonyms;
    public boolean getHasSynonyms() { return has_synonyms; }

    private boolean is_moderator_only;
    public boolean getIsModeratorOnly() { return is_moderator_only; }

    private boolean is_required;
    public boolean getIsRequired() { return is_required; }

    private Long last_activity_date;
    public Date getLastActivityDate() { return last_activity_date != null ? new Date(last_activity_date) : null; }

    private String name;
    public String getName() { return name; }

    private Integer user_id;
    public Integer getUserId() { return user_id; }
}
