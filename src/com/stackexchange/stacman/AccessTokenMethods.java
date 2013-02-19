package com.stackexchange.stacman;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * Stack Exchange API AccessTokens methods
 */
public final class AccessTokenMethods {
    private StacManClient client;

    AccessTokenMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<AccessToken>> invalidate(String[] accessTokens, String filter, Integer page, Integer pageSize){
        return invalidate(StacManClient.toIter(accessTokens), filter, page, pageSize);
    }

    public Future<StacManResponse<AccessToken>> invalidate(Iterable<String> accessTokens, String filter, Integer page, Integer pageSize) {
        StacManClient.validateEnumerable(accessTokens, "accessTokens");
        StacManClient.validatePaging(page, pageSize);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/access-tokens/%1$S/invalidate",
                    StacManClient.join(";", accessTokens)
                ),
                false
            );

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pageSize);

        return client.createApiTask(Types.AccessToken, ub, "/access-tokens/{accessToken}/invalidate");
    }

    public Future<StacManResponse<AccessToken>> get(String[] accessTokens, String filter, Integer page, Integer pageSize) {
        return get(StacManClient.toIter(accessTokens), filter, page, pageSize);
    }

    public Future<StacManResponse<AccessToken>> get(Iterable<String> accessTokens, String filter, Integer page, Integer pageSize) {
        StacManClient.validateEnumerable(accessTokens, "accessTokens");
        StacManClient.validatePaging(page, pageSize);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/access-tokens/%1$S",
                    StacManClient.join(";", accessTokens)
                ),
                false
            );

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pageSize);

        return client.createApiTask(Types.AccessToken, ub, "/access-tokens/{accessTokens}");
    }
}
