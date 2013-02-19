package com.stackexchange.stacman.test;

import com.stackexchange.stacman.Question;
import com.stackexchange.stacman.StacManClient;
import com.stackexchange.stacman.StacManResponse;
import com.stackexchange.stacman.User;
import org.junit.Test;

import java.util.concurrent.Future;

public class QuestionMethodsTest {
    @Test
    public void testGetAll() throws Exception {
        StacManClient client = new StacManClient();
        Future<StacManResponse<Question>> task = client.questions.getAll("stackoverflow", "default", null, null, null, null, null, null, null, null, null, null, null);

        StacManResponse<Question> questions = task.get();

        if(!questions.getSuccess()) throw new Exception();
        if(questions.getData() == null) throw new Exception();
        if(questions.getData().getItems() == null) throw new Exception();
        if(questions.getData().getItems().length == 0) throw new Exception();

        Question topQ = questions.getData().getItems()[0];

        if(topQ.getTitle() == null) throw new Exception();
    }
}
