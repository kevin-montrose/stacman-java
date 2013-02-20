package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class SiteMethods {
    private StacManClient client;

    SiteMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Site>> getAll(String filter, Integer page, Integer pagesize)
    {
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/sites", false);

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Site, ub, "/sites");
    }
}
