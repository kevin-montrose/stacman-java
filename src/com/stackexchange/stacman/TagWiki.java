package com.stackexchange.stacman;

import java.util.Date;

public final class TagWiki {
    private String body;
    public String getBody(){return body;}

    private Long body_last_edit_date;
    public Date getBodyLastEditDate(){return body_last_edit_date != null ? new Date(body_last_edit_date): null;}

    private String excerpt;
    public String getExcerpt(){return excerpt; }

    private Long excerpt_last_edit_date;
    public Date getExcerptLastEditDate(){return excerpt_last_edit_date != null ? new Date(excerpt_last_edit_date): null;}

    private ShallowUser last_body_editor;
    public ShallowUser getLastBodyEditor(){return last_body_editor; }

    private ShallowUser last_excerpt_editor;
    public ShallowUser getLastExcerptEditor(){return last_excerpt_editor; }

    private String tag_name;
    public String getTagName() { return tag_name; }
}
