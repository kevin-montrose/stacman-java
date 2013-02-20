package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class PrivilegeMethods {
    private StacManClient client;

    PrivilegeMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Privilege>> getAll(String site, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/privileges", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Privilege, ub, "/privileges");
    }
}
