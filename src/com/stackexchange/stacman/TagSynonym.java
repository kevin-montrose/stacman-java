package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

public final class TagSynonym implements Serializable {
    private int applied_count;
    public int getAppliedCount(){return applied_count;}

    private long creation_date;
    public Date getCreationDate(){return new Date(creation_date* 1000);}

    private String from_tag;
    public String getFromTag(){return from_tag;}

    private Long last_applied_date;
    public Date getLastAppliedDate(){return last_applied_date != null ? new Date(last_applied_date* 1000) : null;}

    private String to_tag;
    public String getToTag() {return to_tag; }
}
