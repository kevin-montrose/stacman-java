package com.stackexchange.stacman;

import java.io.Serializable;

public final class Info implements Serializable {
    private double answers_per_minute;
    public double getAnswersPerMinute() { return answers_per_minute; }

    private String api_revision;
    public String getApiRevision() { return api_revision; }

    private double badges_per_minute;
    public double getBadgesPerMinute(){return badges_per_minute; }

    private int new_active_users;
    public int getNewActiveUsers(){return new_active_users; }

    private double questions_per_minute;
    public double getQuestionsPerMinute(){return questions_per_minute;}

    private Site site;
    public Site getSite() { return site; }

    private int total_accepted;
    public int getTotalAccepted(){return total_accepted; }

    private int total_answers;
    public int getTotalAnswers(){return total_answers;}

    private int total_badges;
    public int getTotalBadges(){return total_badges;}

    private int total_comments;
    public int getTotalComments(){return total_comments;}

    private int total_questions;
    public int getTotalQuestions(){return total_questions; }

    private int total_unanswered;
    public int getTotalUnanswered(){return total_unanswered; }

    private int total_users;
    public int getTotalUsers(){return total_users; }

    private int total_votes;
    public int getTotalVotes(){return total_votes;}
}
