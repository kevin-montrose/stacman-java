package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class BadgeMethods {
    private StacManClient client;

    BadgeMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<Badge>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, BadgeAllSort sort, BadgeRank minrank, BadgeRank maxrank, String minname, String maxname, BadgeType mintype, BadgeType maxtype, Order order, String inname)
    {
        if(sort == null){
            sort = BadgeAllSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, minrank, maxrank, minname, maxname, mintype, maxtype);

        ApiUrlBuilder ub = new ApiUrlBuilder("/badges", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", minrank);
        ub.addParameter("max", maxrank);
        ub.addParameter("min", minname);
        ub.addParameter("max", maxname);
        ub.addParameter("min", mintype);
        ub.addParameter("max", maxtype);
        ub.addParameter("order", order);
        ub.addParameter("inname", inname);

        return client.createApiTask(Types.Badge, ub, "/badges");
    }
}
