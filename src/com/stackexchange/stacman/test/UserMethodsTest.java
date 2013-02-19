package com.stackexchange.stacman.test;

import com.stackexchange.stacman.StacManClient;
import com.stackexchange.stacman.StacManResponse;
import com.stackexchange.stacman.User;
import org.junit.Test;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: kmontrose
 * Date: 2/19/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserMethodsTest {
    @Test
    public void testGetAll() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<User>> task = client.users.getAll("stackoverflow", "default", null, null, null, null, null, null, null, null, null, null, null, null, null);

        StacManResponse<User> users = task.get();

        if(!users.getSuccess()) throw new Exception();
        if(users.getData() == null) throw new Exception();
        if(users.getData().getItems() == null) throw new Exception();
        if(users.getData().getItems().length == 0) throw new Exception();

        User jon = users.getData().getItems()[0];

        if(!jon.getDisplayName().equals("Jon Skeet")) throw new Exception();
    }
}
