package com.rideveloper.stackexchangeclient;

import com.rideveloper.stackexchangeclient.model.response.QuestionResponse;
import com.rideveloper.stackexchangeclient.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ridwan Mustapha
 */
@RestController
public class TestController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/test")
    public QuestionResponse testThis() {
        return questionService.getQuestions();
    }
}
