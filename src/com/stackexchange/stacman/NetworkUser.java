package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

public final class NetworkUser implements Serializable {
    private int account_id;
    public int getAccountId() { return account_id; }

    private int answer_count;
    public int getAnswerCount(){ return answer_count; }

    private BadgeCount badge_counts;
    public BadgeCount getBadgeCounts() { return badge_counts; }

    private long creation_date;
    public Date getCreationDate(){ return new Date(creation_date* 1000); }

    private long last_access_date;
    public Date getLastAccessDate(){ return new Date(last_access_date* 1000); }

    private int question_count;
    public int getQuestionCount(){ return question_count; }

    private int reputation;
    public int getReputation() { return reputation; }

    private String site_name;
    public String getSiteName() { return site_name; }

    private String site_url;
    public String getSiteUrl() { return site_url; }

    private int user_id;
    public int getUserId() { return user_id; }

    private String user_type;
    public UserType getUserType() { return StacManClient.parseEnum(UserType.class, user_type); }
}
