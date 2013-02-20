package com.stackexchange.stacman;

import java.util.Date;

/**
 * StacMan User, corresponding to Stack Exchange API v2's user type
 * http://api.stackexchange.com/docs/types/user
 */
public final class User {
    private String about_me;
    public String getAboutMe(){ return about_me; }

    private Integer accept_rate;
    public Integer getAcceptRate() { return accept_rate; }

    private int account_id;
    public int getAccountId() { return account_id; }

    private Integer age;
    public Integer getAge(){ return age; }

    private int answer_count;
    public Integer getAnswerCount() { return answer_count; }

    private BadgeCount badge_counts;
    public BadgeCount getBadgeCounts(){ return badge_counts; }

    private long creation_date;
    public Date getCreationDate() { return new Date(creation_date); }

    private String display_name;
    public String getDisplayName() { return display_name; }

    private int down_vote_count;
    public int getDownVoteCount() { return down_vote_count; }

    private boolean is_employee;
    public boolean getIsEmployee() { return is_employee; }

    private long last_access_date;
    public Date getLastAccessDate() { return new Date(last_access_date); }

    private long last_modified_date;
    public Date getLastModifiedDate(){ return new Date(last_modified_date); }

    private String link;
    public String getLink(){ return link; }

    private String location;
    public String getLocation(){return location; }

    private String profile_image;
    public String getProfileImage() { return profile_image; }

    private int question_count;
    public int getQuestionCount() { return question_count; }

    private int reputation;
    public int getReputation(){ return reputation; }

    private int reputation_change_day;
    public int getReputationChangeDay() { return reputation_change_day; }

    private int reputation_change_week;
    public int getReputationChangeWeek(){ return reputation_change_week; }

    private int reputation_change_year;
    public int getReputationChangeYear() { return reputation_change_year; }

    private long timed_penalty_date;
    public Date getTimedPenaltyDate() { return new Date(timed_penalty_date); }

    private int up_vote_count;
    public int getUpVoteCount() { return up_vote_count; }

    private int user_id;
    public int getUserId() { return user_id; }

    private String user_type;
    public UserType getUserType() { return StacManClient.parseEnum(UserType.class, user_type); }

    private int view_count;
    public int getViewCount(){ return view_count; }

    private String website_url;
    public String getWebsiteUrl() { return website_url; }
}
