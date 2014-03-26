package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class AnswerMethods {
    private StacManClient client;

    AnswerMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Answer>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers", false);

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

        return client.createApiTask(Types.Answer, ub, "/answers");
    }

    public Future<StacManResponse<Answer>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getQuestions(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getQuestions(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getQuestions(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/answers/%1$S/questions", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/answers/{ids}/questions");
    }


    public Future<StacManResponse<Answer>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/answers/%1$S", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Answer, ub, "/answers/{ids}");
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

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/answers/%1$S/comments", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Comment, ub, "/answers/{ids}/comments");
    }

    public Future<StacManResponse<Answer>> upvote(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/upvote", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/upvote", true);
    }

    public Future<StacManResponse<Answer>> undoUpvote(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/upvote/undo", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/upvote/undo", true);
    }

    public Future<StacManResponse<Answer>> downvote(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/downvote", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/downvote", true);
    }

    public Future<StacManResponse<Answer>> undoDownvote(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/downvote/undo", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/downvote/undo", true);
    }

    public Future<StacManResponse<Answer>> accept(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/accept", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/accept", true);
    }

    public Future<StacManResponse<Answer>> undoAccept(String access_token, String site, String filter, int answerId, Boolean preview) {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/accept/undo", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/accept/undo", true);
    }

    public Future<StacManResponse<Answer>> edit(String access_token, String site, String filter, int answerId, String body, String comment, Boolean preview)
    {
        client.validateString(site, "site");
        client.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/edit", true);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("body", body);
        ub.addParameter("comment", comment);
        ub.addParameter("preview", preview);

        return client.createApiTask(Types.Answer, ub, "/answers/{id}/edit", true);
    }

    public Future<StacManResponse<FlagOption>> getFlagOptions(String access_token, String site, Integer answerId, String filter) {
        StacManClient.validateString(site, "site");
        StacManClient.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/flags/options", false);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);

        return client.createApiTask(Types.FlagOption, ub, "/answers/{id}/flags/options", false);
    }

    public Future<StacManResponse<Question>> flag(String access_token, String site, Integer answerId, String filter, Integer optionId, String comment, String targetSite, Integer duplicateQuestionId) {
        StacManClient.validateString(site, "site");
        StacManClient.validateString(access_token, "access_token");

        ApiUrlBuilder ub = new ApiUrlBuilder("/answers/"+answerId+"/flags/add", false);
        ub.addParameter("filter", filter);
        ub.addParameter("access_token", access_token);
        ub.addParameter("site", site);
        ub.addParameter("option_id", optionId);
        ub.addParameter("comment", comment);
        ub.addParameter("target_site", targetSite);
        ub.addParameter("question_id", duplicateQuestionId);

        return client.createApiTask(Types.Question, ub, "/answers/{id}/flags/add", true);
    }
}
