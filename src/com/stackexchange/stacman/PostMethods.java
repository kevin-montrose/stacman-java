package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class PostMethods {
    private StacManClient client;

    PostMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Post>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, PostSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = PostSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/posts", false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Post, ub, "/posts");
    }

    public Future<StacManResponse<Post>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, PostSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Post>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, PostSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = PostSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/posts/%1$S", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Post, ub, "/posts/{ids}");
    }

    public Future<StacManResponse<Comment>> getComments(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getComments(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Comment>> getComments(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/posts/%1$S/comments", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Comment, ub, "/posts/{ids}/comments");
    }

    public Future<StacManResponse<Revision>> getRevisions(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate){
        return getRevisions(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate);
    }

    public Future<StacManResponse<Revision>> getRevisions(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate)
    {
        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/posts/%1$S/revisions", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.Revision, ub, "/posts/{ids}/revisions");
    }

    public Future<StacManResponse<SuggestedEdit>> getSuggestedEdits(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order){
        return getSuggestedEdits(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, order);
    }

    public Future<StacManResponse<SuggestedEdit>> getSuggestedEdits(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order)
    {
        if(sort == null){
            sort = SuggestedEditSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/posts/%1$S/suggested-edits", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.SuggestedEdit, ub, "/posts/{ids}/suggested-edits");
    }
}
