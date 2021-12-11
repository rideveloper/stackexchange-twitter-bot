package com.rideveloper.stackexchangeclient.service;

import com.rideveloper.stackexchangeclient.model.response.QuestionResponse;

/**
 * @author Ridwan Mustapha
 */
public interface QuestionService {
    QuestionResponse.Item getQuestionToTweet();
    void saveTweetedQuestion (QuestionResponse.Item question);
}
