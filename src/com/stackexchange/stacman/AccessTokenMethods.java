package com.stackexchange.stacman;

import java.util.concurrent.Future;

/**
 * Stack Exchange API AccessTokens methods
 */
public final class AccessTokenMethods {
    private StacManClient client;

    AccessTokenMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<AccessToken>> Invalidate(Iterable<String> accessTokens, String filter, Integer page, Integer pageSize) {
        StacManClient.validateEnumerable(accessTokens, "accessTokens");

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/access-tokens/{0}/invalidate",
                    StacManClient.join(";", accessTokens)
                ),
                false
            );

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pageSize);

        return client.createApiTask(ub, "/access-tokens/{accessToken}/invalidate");
    }
}
