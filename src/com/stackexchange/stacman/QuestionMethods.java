package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * Stack Exchange API Questions methods
 */
public final class QuestionMethods {
    private StacManClient client;

    QuestionMethods(StacManClient forClient) {
        client = forClient;
    }

    public Future<StacManResponse<Question>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionAllSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged) {
        if(sort == null) {
            sort = QuestionAllSort.Activity;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/questions", false);

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
        ub.addParameter("tagged", tagged);

        return client.createApiTask(Types.Question, ub, "/questions");
    }

    public Future<StacManResponse<Question>> getByIds(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getByIds(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getByIds(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/questions/{ids}");
    }

    public Future<StacManResponse<Answer>> getAnswers(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order){
        return getAnswers(site, StacManClient.toIter(ids),  filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Answer>> getAnswers(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, AnswerSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = AnswerSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S/answers", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Answer, ub, "/questions/{ids}/answers");
    }

    public Future<StacManResponse<Comment>> getComments(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, CommentSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
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

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S/comments", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Comment, ub, "/questions/{ids}/comments");
    }

    public Future<StacManResponse<Question>> getLinked(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionRelatedSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getLinked(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getLinked(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionRelatedSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionRelatedSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S/linked", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/questions/{ids}/linked");
    }

    public Future<StacManResponse<Question>> getRelated(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionRelatedSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getRelated(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<Question>> getRelated(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionRelatedSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = QuestionRelatedSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S/related", StacManClient.join(";", ids)), false);

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

        return client.createApiTask(Types.Question, ub, "/questions/{ids}/related");
    }

    public Future<StacManResponse<QuestionTimeline>> getTimelines(String site, Integer[] ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate) {
        return getTimelines(site, StacManClient.toIter(ids), filter, page, pagesize, fromdate, todate);
    }

    public Future<StacManResponse<QuestionTimeline>> getTimelines(String site, Iterable<Integer> ids, String filter, Integer page, Integer pagesize, Date fromdate, Date todate) {
        client.validateString(site, "site");
        client.validateEnumerable(ids, "ids");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/questions/%1$S/timeline", StacManClient.join(";", ids)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);
        ub.addParameter("fromdate", fromdate);
        ub.addParameter("todate", todate);

        return client.createApiTask(Types.QuestionTimeline, ub, "/questions/{ids}/timeline");
    }

    public Future<StacManResponse<Question>> getFeatured(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged) {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/questions/unanswered", false);

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
        ub.addParameter("tagged", tagged);

        return client.createApiTask(Types.Question, ub, "/questions/unanswered");
    }

    public Future<StacManResponse<Question>> getUnanswered(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/questions/featured", false);

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
        ub.addParameter("tagged", tagged);

        return client.createApiTask(Types.Question, ub, "/questions/featured");
    }

    public Future<StacManResponse<Question>> getWithNoAnswers(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, QuestionSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order, String tagged)
    {
        if(sort == null){
            sort = QuestionSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/questions/no-answers", false);

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
        ub.addParameter("tagged", tagged);

        return client.createApiTask(Types.Question, ub, "/questions/no-answers");
    }
}
