package com.stackexchange.stacman;

import java.io.Serializable;

/**
 * StacMan OriginalQuestion, corresponding to Stack Exchange API v2's question type
 * http://api.stackexchange.com/docs/types/original-question
 */
public class OriginalQuestion implements Serializable {
    private Integer accepted_answer_id;
    public Integer getAcceptedAnswerId() { return accepted_answer_id; }

    private Integer answer_count;
    public Integer getAnswerCount() { return answer_count; }

    private Integer question_id;
    public Integer getQuestionId() { return question_id; }

    private String title;
    public String getTitle() { return title; }
}
