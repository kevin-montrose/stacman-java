package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class InfoMethods {
    private StacManClient client;

    InfoMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Info>> get(String site, String filter)
    {
        client.validateString(site, "site");

        ApiUrlBuilder ub = new ApiUrlBuilder("/info", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Info, ub, "/info");
    }
}
