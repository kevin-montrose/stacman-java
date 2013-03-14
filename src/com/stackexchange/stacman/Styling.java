package com.stackexchange.stacman;

import java.io.Serializable;

/**
 * StacMan Styling, corresponding to Stack Exchange API v2's styling type
 * http://api.stackexchange.com/docs/types/styling
 */
public final class Styling implements Serializable {
    private String link_color;
    public String getLinkColor() { return link_color; }

    private String tag_background_color;
    public String getTagBackgroundColor() { return tag_background_color; }

    private String tag_foreground_color;
    public String getTagForegroundColor() {return tag_foreground_color; }
}
