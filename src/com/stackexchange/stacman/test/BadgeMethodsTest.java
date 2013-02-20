package com.stackexchange.stacman.test;

import com.stackexchange.stacman.*;
import org.junit.Test;

import java.util.concurrent.Future;

public class BadgeMethodsTest {
    @Test
    public void testGetAll() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<Badge>> task = client.badges.getAll("stackoverflow", null, null, null, null, null, null, null, null, null, null, null, null, null, null);

        StacManResponse<Badge> result = task.get();

        if(!result.getSuccess()) throw new Exception();
        if(result.getData() == null) throw new Exception();
        if(result.getData().getItems() == null) throw new Exception();
        if(result.getData().getItems().length == 0) throw new Exception();

        Badge[] badges = result.getData().getItems();
        boolean named = false;
        boolean tagged = false;

        for(int i = 0; i < badges.length; i++){
            if(badges[i].getBadgeType() == null) throw new Exception();
            if(badges[i].getBadgeType() == BadgeType.Named) named = true;
            if(badges[i].getBadgeType() == BadgeType.TagBased) tagged = true;
        }

        if(!named) throw new Exception("named");
        if(!tagged) throw new Exception("tagged");
    }
}
