package com.stackexchange.stacman;

import java.util.Date;
import java.util.concurrent.Future;

public final class TagMethods {
    private StacManClient client;

    TagMethods(StacManClient client){
        this.client = client;
    }

    public Future<StacManResponse<Tag>> getAll(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order, String inname)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/tags", false);

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
        ub.addParameter("inname", inname);

        return client.createApiTask(Types.Tag, ub, "/tags");
    }

    public Future<StacManResponse<Tag>> getByName(String site, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order){
        return getByName(site, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, min, max, mindate, maxdate, minname, maxname, order);
    }

    public Future<StacManResponse<Tag>> getByName(String site, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/info", StacManClient.join(";", tags)), false);

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

        return client.createApiTask(Types.Tag, ub, "/tags/{tags}/info");
    }

    public Future<StacManResponse<Tag>> getModeratorOnly(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order, String inname)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/tags/moderator-only", false);

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
        ub.addParameter("inname", inname);

        return client.createApiTask(Types.Tag, ub, "/tags/moderator-only");
    }

    public Future<StacManResponse<Tag>> getRequired(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSort sort, Integer min, Integer max, Date mindate, Date maxdate, String minname, String maxname, Order order, String inname)
    {
        if(sort == null){
            sort = TagSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, min, max, mindate, maxdate, minname, maxname);

        ApiUrlBuilder ub = new ApiUrlBuilder("/tags/required", false);

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
        ub.addParameter("inname", inname);

        return client.createApiTask(Types.Tag, ub, "/tags/required");
    }

    public Future<StacManResponse<TagSynonym>> getAllSynonyms(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSynonymSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = TagSynonymSort.Default;
        }

        client.validateString(site, "site");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder("/tags/synonyms", false);

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

        return client.createApiTask(Types.TagSynonym, ub, "/tags/synonyms");
    }

    public Future<StacManResponse<Question>> getFrequentlyAsked(String site, String[] tags, String filter, Integer page, Integer pagesize){
        return getFrequentlyAsked(site, StacManClient.toIter(tags), filter, page, pagesize);
    }

    public Future<StacManResponse<Question>> getFrequentlyAsked(String site, Iterable<String> tags, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/faq", StacManClient.join(";", tags)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Question, ub, "/tags/{tags}/faq");
    }

    public Future<StacManResponse<Tag>> getRelated(String site, String[] tags, String filter, Integer page, Integer pagesize)
    {
        return getRelated(site, StacManClient.toIter(tags), filter, page, pagesize);
    }

    public Future<StacManResponse<Tag>> getRelated(String site, Iterable<String> tags, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/related", StacManClient.join(";", tags)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.Tag, ub, "/tags/{tags}/related");
    }

    public Future<StacManResponse<TagSynonym>> getSynonymsForTags(String site, String[] tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSynonymSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order) {
        return getSynonymsForTags(site, StacManClient.toIter(tags), filter, page, pagesize, fromdate, todate, sort, mindate, maxdate, min, max, order);
    }

    public Future<StacManResponse<TagSynonym>> getSynonymsForTags(String site, Iterable<String> tags, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, TagSynonymSort sort, Date mindate, Date maxdate, Integer min, Integer max, Order order)
    {
        if(sort == null){
            sort = TagSynonymSort.Default;
        }

        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);
        client.validateSortMinMax(sort, mindate, maxdate, min, max);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/synonyms", StacManClient.join(";", tags)), false);

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

        return client.createApiTask(Types.TagSynonym, ub, "/tags/{tags}/synonyms");
    }

    public Future<StacManResponse<TagScore>> getTopAnswerers(String site, String tag, TagPeriod period, String filter, Integer page, Integer pagesize)
    {
        if(period == null){
            period = TagPeriod.Default;
        }

        client.validateString(site, "site");
        client.validateString(tag, "tag");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/top-answerers/%2$S", tag, period.toString()), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TagScore, ub, "/tags/{tag}/top-answerers/{period}");
    }

    public Future<StacManResponse<TagScore>> getTopAskers(String site, String tag, TagPeriod period, String filter, Integer page, Integer pagesize)
    {
        if(period == null){
            period = TagPeriod.Default;
        }

        client.validateString(site, "site");
        client.validateString(tag, "tag");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/top-askers/%2$S", tag, period.toString()), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TagScore, ub, "/tags/{tag}/top-askers/{period}");
    }

    public Future<StacManResponse<TagWiki>> getTagWikis(String site, String[] tags, String filter, Integer page, Integer pagesize) {
        return getTagWikis(site, StacManClient.toIter(tags), filter, page, pagesize);
    }

    public Future<StacManResponse<TagWiki>> getTagWikis(String site, Iterable<String> tags, String filter, Integer page, Integer pagesize)
    {
        client.validateString(site, "site");
        client.validateEnumerable(tags, "tags");
        client.validatePaging(page, pagesize);

        ApiUrlBuilder ub = new ApiUrlBuilder(String.format("/tags/%1$S/wikis", StacManClient.join(";", tags)), false);

        ub.addParameter("site", site);
        ub.addParameter("filter", filter);
        ub.addParameter("page", page);
        ub.addParameter("pagesize", pagesize);

        return client.createApiTask(Types.TagWiki, ub, "/tags/{tags}/wikis");
    }
}
