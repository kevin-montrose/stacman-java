package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class InboxMethods {
    private StacManClient client;

    InboxMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<InboxItem>> get(String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/inbox", true);

        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.InboxItem, ub, "/inbox");
    }

    public Future<StacManResponse<InboxItem>> getUnread(String access_token, String filter, Integer page, Integer pagesize, Date since)
    {
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/inbox/unread", true);

        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("since", since);

        return client.createApiTask(Types.InboxItem, ub, "/inbox/unread");
    }
}
