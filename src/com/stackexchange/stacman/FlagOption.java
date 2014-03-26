package com.stackexchange.stacman;

import java.io.Serializable;

/**
 * StacMan FlagOption, corresponding to Stack Exchange API v2's flag option type
 * http://api.stackexchange.com/docs/types/flag-option
 */
public class FlagOption implements Serializable {
    private Integer count;
    public Integer getCount() { return count; }

    private String description;
    public String getDescription() { return description; }

    private boolean has_flagged;
    public boolean getHasFlagged() { return has_flagged; }

    private Integer option_id;
    public Integer getOptionId() { return option_id; }

    private boolean requires_comment;
    public boolean getRequiresComments() { return requires_comment; }

    private boolean requires_question_id;
    public boolean getRequiresQuestionId() { return requires_question_id; }

    private boolean requires_site;
    public boolean getRequiresSite() { return requires_site; }

    private FlagOption[] sub_options;
    public FlagOption[] getSubOptions() { return sub_options; }

    private String title;
    public String getTitle() { return title; }

    private String dialog_title;
    public String getDialogTitle() { return dialog_title; }
}
