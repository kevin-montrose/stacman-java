package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class ApplicationMethods {
    private StacManClient client;

    ApplicationMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<AccessToken>> deauthenticate(String[] accessTokens, String filter, Integer page, Integer pagesize) {
        return deauthenticate(StacManClient.toIter(accessTokens), filter, page, pagesize);
    }

    public Future<StacManResponse<AccessToken>> deauthenticate(Iterable<String> accessTokens, String filter, Integer page, Integer pagesize)
    {
        client.validateEnumerable(accessTokens, "accessTokens");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/apps/%1$S/de-authenticate", StacManClient.join(";", accessTokens)), false);

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.AccessToken, ub, "/apps/{accessTokens}/de-authenticate");
    }
}
