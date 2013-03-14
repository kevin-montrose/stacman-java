package com.stackexchange.stacman;

import java.io.Serializable;

public final class Filter implements Serializable {
    private String filter;
    public String getFilterName() { return filter; }

    private String filter_type;
    public FilterType getFilterType() { return StacManClient.parseEnum(FilterType.class, filter_type); }

    private String[] included_fields;
    public String[] getIncludedFields() { return included_fields; }
}
