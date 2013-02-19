package com.stackexchange.stacman;

import java.util.ArrayList;
import java.util.Date;

/**
 * StacMan AccessToken, corresponding to Stack Exchange API v2's access_token type
 * http://api.stackexchange.com/docs/types/access-token
 */
public final class AccessToken {
    private String accessTokenName;
    public String getAccessTokenName() { return accessTokenName; }

    private int accountId;
    public int getAccountId() { return accountId; }

    private Date expiresOnDate;
    public Date getExpiresOnDate(){ return expiresOnDate;}

    private ArrayList<String> scope;
    public Iterable<String> getScope() { return scope; }
}
