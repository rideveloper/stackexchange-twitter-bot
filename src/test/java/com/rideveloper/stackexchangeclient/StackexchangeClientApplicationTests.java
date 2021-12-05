package com.rideveloper.stackexchangeclient;

import com.rideveloper.stackexchangeclient.service.QuestionService;
import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StackexchangeClientApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    final void whenRequestIsPerformed_thenNoExceptions() throws ClientProtocolException, IOException {
        questionService.getQuestions();
    }

}
