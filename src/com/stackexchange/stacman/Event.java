package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

public final class Event implements Serializable {
    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date* 1000); }

    private int event_id;
    public int getEventId() { return event_id; }

    private String event_type;
    public EventType getEventType() { return StacManClient.parseEnum(EventType.class, event_type); }

    private String excerpt;
    public String getExcerpt() { return excerpt; }

    private String link;
    public String getLink() { return link; }
}
