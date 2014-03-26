package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class CommentMethods {
    private StacManClient client;

    CommentMethods(StacManClient client) {
        this.client = client;
    }

    public Future<StacManResponse<Comment>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/comments", false);

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

        return client.createApiTask(Types.Comment, ub, "/comments");
    }

    public Future<StacManResponse<Comment>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Comment>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/comments/%1$S", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Comment, ub, "/comments/{ids}");
    }

    public Future<StacManResponse<Comment>> upvote(String access_token, String site, Integer id, String filter)
    {
        client.validateString(access_token, "access_token");
        client.validateString(site, "site");

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/comments/%1$S/upvote", id), true);
        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Comment, ub, String.format("/comments/%1$S/upvote", id), true);
    }

    public Future<StacManResponse<Comment>> create(String access_token, String site, Integer postId, String filter, String body) {
        client.validateString(access_token, "access_token");
        client.validateString(site, "site");

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/posts/%1$S/comments/add", postId), true);
        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("body", body);

        return client.createApiTask(Types.Comment, ub, String.format("/posts/%1$S/comments/add", postId), true);
    }

    public Future<StacManResponse<Comment>> edit(String access_token, String site, Integer id, String filter, String body) {
        client.validateString(access_token, "access_token");
        client.validateString(site, "site");

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/comments/%1$S/edit", id), true);
        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("body", body);

        return client.createApiTask(Types.Comment, ub, String.format("/comments/%1$S/edit", id), true);
    }

    public Future<StacManResponse<Comment>> delete(String access_token, String site, Integer id, String filter) {
        client.validateString(access_token, "access_token");
        client.validateString(site, "site");

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/comments/%1$S/delete", id), true);
        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Comment, ub, String.format("/comments/%1$S/delete", id), true);
    }

    public Future<StacManResponse<FlagOption>> getFlagOptions(String access_token, String site, Integer commentId, String filter) {
        StacManClient.validateString(site, "site");
        StacManClient.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/comments/"+commentId+"/flags/options", false);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);

        return client.createApiTask(Types.FlagOption, ub, "/comments/{id}/flags/options", false);
    }

    public Future<StacManResponse<Comment>> flag(String access_token, String site, Integer commentId, String filter, Integer optionId, String comment, String targetSite, Integer duplicateQuestionId) {
        StacManClient.validateString(site, "site");
        StacManClient.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/comments/"+commentId+"/flags/add", false);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("option_id", optionId);
        ub.addParameter("comment", comment);
        ub.addParameter("target_site", targetSite);
        ub.addParameter("question_id", duplicateQuestionId);

        return client.createApiTask(Types.Question, ub, "/comments/{id}/flags/add", true);
    }

}
