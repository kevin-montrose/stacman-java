package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class SearchMethods {
    private StacManClient client;

    SearchMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Question>> getMatches(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSearchSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged, String nottagged, String inttitle)
    {
        if(sort == null){
            sort = QuestionSearchSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/search", false);

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
        ub.addParameter("nottagged", nottagged);
        ub.addParameter("inttitle", inttitle);

        return client.createApiTask(Types.Question, ub, "/search");
    }

    public Future<StacManResponse<Question>> getSimilar(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSearchSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged, String nottagged, String inttitle)
    {
        if(sort == null){
            sort = QuestionSearchSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/similar", false);

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
        ub.addParameter("nottagged", nottagged);
        ub.addParameter("inttitle", inttitle);

        return client.createApiTask(Types.Question, ub, "/similar");
    }
}
