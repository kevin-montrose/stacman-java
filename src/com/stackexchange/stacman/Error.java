package com.stackexchange.stacman;

import java.io.Serializable;

public final class Error implements Serializable {
    private String description;
    public String getDescription() { return description; }

    private int error_id;
    public int getErrorId(){ return error_id; }

    private String error_name;
    public String getErrorName(){ return error_name; }
}
