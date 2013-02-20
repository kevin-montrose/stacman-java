package com.stackexchange.stacman;
import sun.reflect.generics.tree.TypeSignature;

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

    public Future<StacManResponse<Answer>> getAnswers(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getAnswers(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Answer>> getAnswers(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/answers",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Answer, ub, "/_users/answers");
    }

    public Future<StacManResponse<Answer>> getMyAnswers(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        if(sort == null) {
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/answers", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Answer, ub, "/_users/answers");
    }

    public Future<StacManResponse<Badge>> getBadges(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, BadgeUserSort sort, BadgeRank minrank, BadgeRank maxrank, String minname, String maxname, BadgeType mintype, BadgeType maxtype, Date mindate, Date maxdate, Order order) {
        return getBadges(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, minrank, maxrank, minname, maxname, mintype, maxtype, mindate, maxdate, order);
    }

    public Future<StacManResponse<Badge>> getBadges(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, BadgeUserSort sort, BadgeRank minrank, BadgeRank maxrank, String minname, String maxname, BadgeType mintype, BadgeType maxtype, Date mindate, Date maxdate, Order order) {
        if(sort == null) {
            sort = BadgeUserSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, minrank, maxrank, minname, maxname, mintype, maxtype, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/badges", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", minrank);
        ub.addParameter("max", maxrank);
        ub.addParameter("min", minname);
        ub.addParameter("max", maxname);
        ub.addParameter("min", mintype);
        ub.addParameter("max", maxtype);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Badge, ub, "/_users/badges");
    }

    public Future<StacManResponse<Badge>> getMyBadges(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, BadgeUserSort sort, BadgeRank minrank, BadgeRank maxrank, String minname, String maxname, BadgeType mintype, BadgeType maxtype, Date mindate, Date maxdate, Order order)
    {
        if(sort == null) {
            sort = BadgeUserSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, minrank, maxrank, minname, maxname, mintype, maxtype, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/badges", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", minrank);
        ub.addParameter("max", maxrank);
        ub.addParameter("min", minname);
        ub.addParameter("max", maxname);
        ub.addParameter("min", mintype);
        ub.addParameter("max", maxtype);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Badge, ub, "/_users/badges");
    }

    public Future<StacManResponse<Comment>> getComments(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null) {
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/{0}/comments",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Comment, ub, "/_users/comments");
    }

    public Future<StacManResponse<Comment>> getMyComments(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/comments", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Comment, ub, "/_users/comments");
    }

    public Future<StacManResponse<Comment>> getCommentsToUser(String site, Integer[] ids, int toid, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getCommentsToUser(site, StacManClient.toIter(ids), toid, filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Comment>> getCommentsToUser(String site, Iterable<Integer> ids, int toid, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/comments/%2$d",
                    StacManClient.join(";", ids),
                    toid
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Comment, ub, "/_users/comments/{toid}");
    }

    public Future<StacManResponse<Comment>> getMyCommentsToUser(String site, String access_token, int toid, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/me/comments/%1$d",
                    toid),
                true
            );

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Comment, ub, "/_users/comments/{toid}");
    }

    public Future<StacManResponse<Question>> getFavorites(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionFavoriteSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getFavorites(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getFavorites(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionFavoriteSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionFavoriteSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/favorites",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Question, ub, "/_users/favorites");
    }

    public Future<StacManResponse<Question>> getMyFavorites(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionFavoriteSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionFavoriteSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/favorites", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/favorites");
    }

    public Future<StacManResponse<Comment>> getCommentsMentionedIn(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getCommentsMentionedIn(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Comment>> getCommentsMentionedIn(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/mentioned",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Comment, ub, "/_users/mentioned");
    }

    public Future<StacManResponse<Comment>> getMyCommentsMentionedIn(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = CommentSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/mentioned", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Comment, ub, "/_users/mentioned");
    }

    public Future<StacManResponse<Privilege>> getPrivileges(String site, int id, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/privileges", id), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Privilege, ub, "/_users/privileges");
    }

    public Future<StacManResponse<Privilege>> getMyPrivileges(String site, String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/privileges", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Privilege, ub, "/_users/privileges");
    }

    public Future<StacManResponse<Question>> getQuestions(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getQuestions(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getQuestions(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/questions",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Question, ub, "/_users/questions");
    }

    public Future<StacManResponse<Question>> getMyQuestions(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/questions", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/questions");
    }

    public Future<StacManResponse<Question>> getFeaturedQuestions(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getFeaturedQuestions(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getFeaturedQuestions(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/questions/featured",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Question, ub, "/_users/questions/featured");
    }

    public Future<StacManResponse<Question>> getMyFeaturedQuestions(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/questions/featured", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/questions/featured");
    }

    public Future<StacManResponse<Question>> getQuestionsWithNoAnswers(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getQuestionsWithNoAnswers(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min ,max, order);
    }

    public Future<StacManResponse<Question>> getQuestionsWithNoAnswers(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format(
                    "/users/%1$S/questions/no-answers",
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
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("min", min);
        ub.addParameter("max", max);
        ub.addParameter("order", order);

        return client.createApiTask(Types.Question, ub, "/_users/questions/no-answers");
    }

    public Future<StacManResponse<Question>> getMyQuestionsWithNoAnswers(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/questions/no-answers", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/questions/no-answers");
    }

    public Future<StacManResponse<Question>> getQuestionsWithUnaccepted(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getQuestionsWithUnaccepted(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getQuestionsWithUnaccepted(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/questions/unaccepted", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/_users/questions/unaccepted");
    }

    public Future<StacManResponse<Question>> getMyQuestionsWithUnaccepted(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/questions/unaccepted", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/questions/unaccepted");
    }

    public Future<StacManResponse<Question>> getUnansweredQuestions(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getUnansweredQuestions(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getUnansweredQuestions(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/questions/unanswered", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/_users/questions/unanswered");
    }

    public Future<StacManResponse<Reputation>> getReputation(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate) {
        return getReputation(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate);
    }

    public Future<StacManResponse<Reputation>> getReputation(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate)
    {
        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/reputation", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.Reputation, ub, "/_users/reputation");
    }

    public Future<StacManResponse<Reputation>> gtMyReputation(String site, String access_token, String filter)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/reputation", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);

        return client.createApiTask(Types.Reputation, ub, "/_users/reputation");
    }

    public Future<StacManResponse<SuggestedEdit>> getSuggestedEdits(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order) {
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

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/suggested-edits", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.SuggestedEdit, ub, "/_users/suggested-edits");
    }

    public Future<StacManResponse<SuggestedEdit>> getMySuggestedEdits(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SuggestedEditSort sort, Date mindate, Date maxdate, Order order)
    {
        if(sort == null){
            sort = SuggestedEditSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/suggested-edits", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);
        ub.addParameter("sort", sort);
        ub.addParameter("min", mindate);
        ub.addParameter("max", maxdate);
        ub.addParameter("order", order);

        return client.createApiTask(Types.SuggestedEdit, ub, "/_users/suggested-edits");
    }

    public Future<StacManResponse<Tag>> getTags(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order) {
        return getTags(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, min, max, mindate, maxdate, minname, maxname, order);
    }

    public Future<StacManResponse<Tag>> getTags(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/tags", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Tag, ub, "/_users/tags");
    }

    public Future<StacManResponse<Tag>> getMyTags(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/tags", true);

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

        return client.createApiTask(Types.Tag, ub, "/_users/tags");
    }

    public Future<StacManResponse<Answer>> getTopAnswers(String site, int id, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getTopAnswers(site, id, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Answer>> getTopAnswers(String site, int id, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/tags/%2$S/top-answers", id, StacManClient.join(";", tags)), false);

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

        return client.createApiTask(Types.Answer, ub, "/_users/tags/{tags}/top-answers");
    }

    public Future<StacManResponse<Answer>> getMyTopAnswers(String site, String access_token, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getMyTopAnswers(site, access_token, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Answer>> getMyTopAnswers(String site, String access_token, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/me/tags/%1$S/top-answers", StacManClient.join(";", tags)), true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Answer, ub, "/_users/tags/{tags}/top-answers");
    }

    public Future<StacManResponse<Question>> getTopQuestions(String site, int id, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getTopQuestions(site, id, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getTopQuestions(String site, int id, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/tags/%2$S/top-questions", id, StacManClient.join(";", tags)), false);

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

        return client.createApiTask(Types.Question, ub, "/_users/tags/{tags}/top-questions");
    }

    public Future<StacManResponse<Question>> getMyTopQuestions(String site, String access_token, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getMyTopQuestions(site, access_token, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getMyTopQuestions(String site, String access_token, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/me/tags/%1$S/top-questions", StacManClient.join(";", tags)), true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
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

        return client.createApiTask(Types.Question, ub, "/_users/tags/{tags}/top-questions");
    }

    public Future<StacManResponse<UserTimeline>> getTimelines(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate) {
        return getTimelines(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate);
    }

    public Future<StacManResponse<UserTimeline>> getTimelines(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate)
    {
        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/timeline", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.UserTimeline, ub, "/_users/timeline");
    }

    public Future<StacManResponse<UserTimeline>> getMyTimeline(String site, String access_token, String filter, Integer page, Integer pagesize, Date fromdate, Date todate)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/timeline", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.UserTimeline, ub, "/_users/timeline");
    }

    public Future<StacManResponse<TopTag>> getTopAnswerTags(String site, int id, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/top-answer-tags", id), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TopTag, ub, "/_users/top-answer-tags");
    }

    public Future<StacManResponse<TopTag>> getMyTopAnswerTags(String site, String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/top-answer-tags", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TopTag, ub, "/_users/top-answer-tags");
    }

    public Future<StacManResponse<TopTag>> getTopQuestionTags(String site, int id, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/top-question-tags", id), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TopTag, ub, "/_users/top-question-tags");
    }

    public Future<StacManResponse<TopTag>> getMyTopQuestionTags(String site, String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/top-question-tags", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TopTag, ub, "/_users/top-question-tags");
    }

    public Future<StacManResponse<User>> getModerators(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, UserSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order)
    {
        if(sort == null){
            sort = UserSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/users/moderators", false);

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

        return client.createApiTask(Types.User, ub, "/users/moderators");
    }

    public Future<StacManResponse<User>> getElectedModerators(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, UserSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order)
    {
        if(sort == null){
            sort = UserSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/users/moderators/elected", false);

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

        return client.createApiTask(Types.User, ub, "/users/moderators/elected");
    }

    public Future<StacManResponse<InboxItem>> getInbox(String site, String access_token, int id, String filter, Integer page, Integer pagesize) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub =
            new ApiUrlBuilder(
                String.format("/users/%1$d/inbox", id),
                true
            );

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.InboxItem, ub, "/_users/inbox");
    }

    public Future<StacManResponse<InboxItem>> getMyInbox(String site, String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/inbox", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.InboxItem, ub, "/_users/inbox");
    }

    public Future<StacManResponse<InboxItem>> getInboxUnread(String site, String access_token, int id, String filter, Integer page, Integer pagesize, Date since)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$d/inbox/unread", id), true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("since", since);

        return client.createApiTask(Types.InboxItem, ub, "/_users/inbox/unread");
    }

    public Future<StacManResponse<InboxItem>> getMyInboxUnread(String site, String access_token, String filter, Integer page, Integer pagesize, Date since)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/inbox/unread", true);

        ub.addParameter("site", site);
        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("since", since);

        return client.createApiTask(Types.InboxItem, ub, "/_users/inbox/unread");
    }

    public Future<StacManResponse<NetworkUser>> getAssociated(Integer[] ids, String filter, Integer page, Integer pagesize) {
        return getAssociated(StacManClient.toIter(ids), filter, page, pagesize);
    }

    public Future<StacManResponse<NetworkUser>> getAssociated(Iterable<Integer> ids, String filter, Integer page, Integer pagesize)
    {
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/users/%1$S/associated", StacManClient.join(";", ids)), false);

        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.NetworkUser, ub, "/_users/associated");
    }

    public Future<StacManResponse<NetworkUser>> getMyAssociated(String access_token, String filter, Integer page, Integer pagesize)
    {
        client.validateString(access_token, "access_token");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder("/me/associated", true);

        ub.addParameter("access_token", access_token);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.NetworkUser, ub, "/_users/associated");
    }
}
