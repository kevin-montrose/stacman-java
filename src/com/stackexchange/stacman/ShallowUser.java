package com.stackexchange.stacman;

/**
 * StacMan ShallowUser, corresponding to Stack Exchange API v2's shallow_user type
 * http://api.stackexchange.com/docs/types/shallow-user
 */
public final class ShallowUser {
    private Integer accept_rate;
    public Integer getAcceptRate(){ return accept_rate; }

    private String display_name;
    public String getDisplayName(){ return display_name;}

    private String link;
    public String getLink(){return link; }

    private String profile_image;
    public String getProfileImage() { return profile_image; }

    private Integer reputation;
    public Integer getReputation() {return reputation; }

    private Integer user_id;
    public Integer getUserId() { return user_id; }

    private String user_type;
    public UserType getUserType() { return StacManClient.parseEnum(UserType.class, user_type); }
}
