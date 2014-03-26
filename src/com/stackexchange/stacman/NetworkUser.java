package com.stackexchange.stacman;

import java.io.Serializable;
import java.util.Date;

public final class NetworkUser implements Serializable {
    public NetworkUser(NetworkUser networkUser)
    {
        account_id = networkUser.account_id;
        answer_count = networkUser.answer_count;
        badge_counts = networkUser.badge_counts;
        creation_date = networkUser.creation_date;
        last_access_date = networkUser.last_access_date;
        question_count = networkUser.question_count;
        reputation = networkUser.reputation;
        site_name = networkUser.site_name;
        site_url = networkUser.site_url;
        user_id = networkUser.user_id;
        user_type = networkUser.user_type;
    }

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
