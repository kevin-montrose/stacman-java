package com.stackexchange.stacman.test;

import com.stackexchange.stacman.*;
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
        if(users.getData().getItems().size() == 0) throw new Exception();

        User jon = users.getData().getItems().toArray(new User[0])[0];

        if(!jon.getDisplayName().equals("Jon Skeet")) throw new Exception();
        if(jon.getUserType() != UserType.Registered) throw new Exception();
    }

    @Test
    public void testBadges() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<Badge>> task = client.users.getBadges("stackoverflow", new Integer[] { 22656 }, "default", null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        StacManResponse<Badge> badges = task.get();

        if(!badges.getSuccess()) throw new Exception();
        if(badges.getData() == null) throw new Exception();
        if(badges.getData().getItems() == null) throw new Exception();
        if(badges.getData().getItems().size() == 0) throw new Exception();

        Badge jon = badges.getData().getItems().toArray(new Badge[0])[0];

        if(jon.getName() == null) throw new Exception();
    }
}
