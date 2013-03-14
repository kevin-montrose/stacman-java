package com.stackexchange.stacman;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.io.Serializable;
import java.util.Date;

/**
 * StacMan MigrationInfo, corresponding to Stack Exchange API v2's migration_info type
 * http://api.stackexchange.com/docs/types/migration-info
 */
public final class MigrationInfo implements Serializable {
    private long on_date;
    public Date getOnDate() { return new Date(on_date* 1000); }

    private Site other_site;
    public Site getOtherSite() { return other_site; }

    private int question_id;
    public int getQuestionId() { return question_id; }
}
