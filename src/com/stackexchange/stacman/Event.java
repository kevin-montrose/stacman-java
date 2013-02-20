package com.stackexchange.stacman;

import java.util.Date;

public final class Event {
    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date); }

    private int event_id;
    public int getEventId() { return event_id; }

    private String event_type;
    public EventType getEventType() { return EventType.valueOf(event_type); }

    private String excerpt;
    public String getExcerpt() { return excerpt; }

    private String link;
    public String getLink() { return link; }
}
