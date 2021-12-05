package com.rideveloper.stackexchangeclient.service.impl;

import com.rideveloper.stackexchangeclient.model.response.QuestionResponse;
import com.rideveloper.stackexchangeclient.service.QuestionService;
import com.rideveloper.stackexchangeclient.util.CustomRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author Ridwan Mustapha
 */

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final CustomRestService restService;
    private final Environment env;

    public QuestionServiceImpl(CustomRestService restService, Environment env) {
        this.restService = restService;
        this.env = env;
    }

    @Override
    public QuestionResponse getQuestions() {
        QuestionResponse response = null;
        String URL = env.getProperty("stackexchange.url");
        try {
            response = restService.makeRequest(URL, null, HttpMethod.GET, QuestionResponse.class);
        } catch (Exception ex) {
            log.error("Error occurred {}", ex.getMessage());
        }

        return response;
    }
}
