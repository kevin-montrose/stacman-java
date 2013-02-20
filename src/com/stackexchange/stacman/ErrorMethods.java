package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class ErrorMethods {
    private StacManClient client;

    ErrorMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Error>> getAll(String filter, Integer page, Integer pagesize)
    {
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/errors", false);

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Error, ub, "/errors");
    }

    public Future<StacManResponse<Error>> simulate(int id, String filter)
    {
        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/errors/%1$d", id), false);

        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Error, ub, "/errors/{id}");
    }
}
