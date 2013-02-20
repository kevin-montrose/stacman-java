package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class SuggestedEditMethods {
    private StacManClient client;

    SuggestedEditMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<SuggestedEdit>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order)
    {
        if(sort == null){
            sort = SuggestedEditSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder("/suggested-edits", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.SuggestedEdit, ub, "/suggested-edits");
    }

    public Future<StacManResponse<SuggestedEdit>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order){
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, order);
    }

    public Future<StacManResponse<SuggestedEdit>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order)
    {
        if(sort == null){
            sort = SuggestedEditSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/suggested-edits/%1$S", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.SuggestedEdit, ub, "/suggested-edits/{ids}");
    }
}
