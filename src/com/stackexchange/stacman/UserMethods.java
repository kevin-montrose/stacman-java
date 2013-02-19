package com.stackexchange.stacman;

import com.google.gson.reflect.TypeToken;
import com.sun.jmx.remote.util.OrderClassLoaders;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * Stack Exchange API Users methods
 */
public final class UserMethods {
    private StacManClient client;

    UserMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<User>> getAll(String site, String filter, Integer page, Integer pageSize, Date fromDate, Date toDate, UserSort sort, Integer min, Integer max, Date minDate, Date maxDate, String minName, String maxName, Order order, String inName) {
        if(sort == null){
            sort = UserSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pageSize);
        client.validateSortMinMax(sort, min, max, minDate, maxDate, minName, maxName);

        ApiUrlBuilder ub = new ApiUrlBuilder("/users", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pageSize);
        ub.addParameter("fromdate", fromDate);
        ub.addParameter("todate", toDate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("min", minDate);
        ub.addParameter("max", maxDate);
        ub.addParameter("min", minName);
        ub.addParameter("max", maxName);
        ub.addParameter("order", order);
        ub.addParameter("inname", inName);

        return client.createApiTask(Types.User, ub, "/users");
    }
}
