package com.stackexchange.stacman;

public final class TopTag {
    private int answer_count;
    public int getAnswerCount() { return answer_count; }

    private int answer_score;
    public int getAnswerScore() { return answer_score; }

    private int question_count;
    public int getQuestionCount(){ return question_count; }

    private int question_score;
    public int getQuestionScore(){ return question_score; }

    private String tag_name;
    public String getTagName() { return tag_name; }
}
