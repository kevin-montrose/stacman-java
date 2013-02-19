package com.stackexchange.stacman;

/**
 * StacMan RelatedSite, corresponding to Stack Exchange API v2's related_site type
 * http://api.stackexchange.com/docs/types/related-site
 */
public final class RelatedSite {
    private String api_site_parameter;
    public String getApiSiteParameter() { return api_site_parameter; }

    private String name;
    public String getName(){ return name; }

    private String relation;
    public String getRelation(){ return relation; }

    private String site_url;
    public String getSiteUrl(){ return site_url; }
}
