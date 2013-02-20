package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class EventMethods {
    private StacManClient client;

    EventMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Event>> getRecent(String site, String access_token, String filter, Integer page, Integer pagesize, Date since)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/events", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("since", since);

        return client.createApiTask(Types.Event, ub, "/events");
    }
}
