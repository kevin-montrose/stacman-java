package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * Stack Exchange API Questions methods
 */
public final class QuestionMethods {
    private StacManClient client;

    QuestionMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<Question>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionAllSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged) {
        if(sort == null) {
            sort = QuestionAllSort.Activity;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/questions", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);
        ub.addParameter("tagged", tagged);

        return client.createApiTask(Types.Question, ub, "/questions");
    }
}
