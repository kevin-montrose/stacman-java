package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

/**
 * StacMan Site, corresponding to Stack Exchange API v2's site type
 * http://api.stackexchange.com/docs/types/site
 */
public final class Site implements Serializable {
    private String[] aliases;
    public String[] getAliases(){ return aliases; }

    private String api_site_parameter;
    public String getApiSiteParameter() { return api_site_parameter; }

    private String audience;
    public String getAudience(){ return audience; }

    private Long closed_beta_date;
    public Date getClosedBetaDate(){ return closed_beta_date != null ? new Date(closed_beta_date* 1000) : null; }

    private String favicon_url;
    public String getFaviconUrl() { return favicon_url; }

    private String icon_url;
    public String getIconUrl() { return icon_url; }

    private Long launch_date;
    public Date getLaunchDate() { return launch_date != null ? new Date(launch_date* 1000) : null; }

    private String logo_url;
    public String getLogoUrl() { return logo_url; }

    private String[] markdown_extensions;
    public String[] getMarkdownExtensions() { return markdown_extensions; }

    private String name;
    public String getName(){ return name; }

    private Long open_beta_date;
    public Date getOpenBetaDate() { return open_beta_date != null ? new Date(open_beta_date* 1000) : null; }

    private RelatedSite[] related_site;
    public RelatedSite[] getRelatedSite() { return related_site; }

    private String site_state;
    public SiteState getSiteState() { return StacManClient.parseEnum(SiteState.class, site_state); }

    private String site_type;
    public String getSiteType() { return site_type; }

    private String site_url;
    public String getSiteUrl() { return site_url; }

    private Styling styling;
    public Styling getStyling() { return styling; }

    private String twitter_account;
    public String getTwitterAccount() { return twitter_account; }
}
