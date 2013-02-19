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

    public Future<StacManResponse<User>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, UserSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, min, max, mindate, maxdate, minname, maxname, order);
    }

    public Future<StacManResponse<User>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, UserSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order) {
        if(sort == null) {
            sort = UserSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S",
                    StacManClient.join(";", ids)
                ),
                false
            );

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", minname);
        ub.addParameter("max", maxname);
        ub.addParameter("order", order);

        return client.createApiTask(Types.User, ub, "/_users");
    }

    public Future<StacManResponse<User>> getMe(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, UserSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order) {
        if(sort == null) {
            sort = UserSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", minname);
        ub.addParameter("max", maxname);
        ub.addParameter("order", order);

        return client.createApiTask(Types.User, ub, "/_users");
    }
}
