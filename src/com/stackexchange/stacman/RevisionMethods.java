package com.stackexchange.stacman;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Future;

public final class RevisionMethods {
    private StacManClient client;

    RevisionMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Revision>> getByIds(String site, UUID[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate);
    }

    public Future<StacManResponse<Revision>> getByIds(String site, Iterable<UUID> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate)
    {
        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/revisions/%1$S", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.Revision, ub, "/revisions/{ids}");
    }
}
