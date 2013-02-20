package com.stackexchange.stacman;

import java.util.concurrent.Future;

public final class FilterMethods {
    private StacManClient client;

    FilterMethods(StacManClient client) {
        this.client = client;
    }

    public Future<StacManResponse<Filter>> read(String[] filters, String filter) {
        return read(StacManClient.toIter(filters), filter);
    }

    public Future<StacManResponse<Filter>> read(Iterable<String> filters, String filter)
    {
        client.validateEnumerable(filters, "filters");

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/filters/%1$S", StacManClient.join(";", filters)), false);

        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Filter, ub, "/filters/{filters}");
    }

    public Future<StacManResponse<Filter>> create(String filter, String[] include, String[] exclude, String base, Boolean unsafe) {
        return create(filter, StacManClient.toIter(include), StacManClient.toIter(exclude), base, unsafe);
    }

    public Future<StacManResponse<Filter>> create(String filter, Iterable<String> include, Iterable<String> exclude, String base, Boolean unsafe)
    {
        ApiUrlBuilder ub = new ApiUrlBuilder("/filters/create", false);

        ub.addParameter("filter", filter);
        ub.addParameter("include", include);
        ub.addParameter("exclude", exclude);
        ub.addParameter("base", base);
        ub.addParameter("unsafe", unsafe);

        return client.createApiTask(Types.Filter, ub, "/filters/create");
    }
}
