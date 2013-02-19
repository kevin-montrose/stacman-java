package com.stackexchange.stacman.test;

import com.stackexchange.stacman.AccessToken;
import com.stackexchange.stacman.StacManClient;
import com.stackexchange.stacman.StacManResponse;
import org.junit.Test;

import java.util.concurrent.Future;

public class AccessTokenMethodsTest {
    @Test
    public void testInvalidate() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<AccessToken>> task = client.accessTokens.invalidate(new String[] { "hello" }, "default", 1, 30);

        StacManResponse<AccessToken> result = task.get();

        if(!result.getSuccess()) throw new Exception();
    }

    @Test
    public void testGet() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<AccessToken>> task = client.accessTokens.get(new String[] { "hello" }, "default", 1, 30);

        StacManResponse<AccessToken> result = task.get();

        if(!result.getSuccess()) throw new Exception();
    }
}
