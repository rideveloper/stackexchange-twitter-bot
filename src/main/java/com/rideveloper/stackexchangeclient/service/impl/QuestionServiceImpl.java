package com.rideveloper.stackexchangeclient.service.impl;

import com.rideveloper.stackexchangeclient.model.Tweet;
import com.rideveloper.stackexchangeclient.model.response.QuestionResponse;
import com.rideveloper.stackexchangeclient.repo.QuestionTweetRepo;
import com.rideveloper.stackexchangeclient.service.QuestionService;
import com.rideveloper.stackexchangeclient.util.CustomRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Ridwan Mustapha
 */

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final CustomRestService restService;
    private final Environment env;
    private final QuestionTweetRepo repo;

    public QuestionServiceImpl(CustomRestService restService, Environment env, QuestionTweetRepo repo) {
        this.restService = restService;
        this.env = env;
        this.repo = repo;
    }

    private QuestionResponse getQuestions() {
        QuestionResponse response = null;
        String URL = env.getProperty("stackexchange.url");
        try {
            response = restService.makeRequest(URL, null, HttpMethod.GET, QuestionResponse.class);
        } catch (Exception ex) {
            log.error("Error occurred {}", ex.getMessage());
        }

        return response;
    }

    @Override
    public QuestionResponse.Item getQuestionToTweet() {
        for (QuestionResponse.Item question : getQuestions().getItems()) {
            if (!isQuestionTweeted(question)) {
                return question;
            }
        }

        return null;
    }

    private boolean isQuestionTweeted(QuestionResponse.Item question) {
        return repo.findById(question.getQuestion_id()).isPresent();
    }

    @Override
    public void saveTweetedQuestion (QuestionResponse.Item question) {
        Tweet tweet = new Tweet();
        try {
            tweet.setQuestionId(question.getQuestion_id());
            tweet.setTweetTimestamp(LocalDateTime.now());

            repo.save(tweet);
        } catch (Exception ex) {
            log.error("Error saving tweet to DB because {}", ex.getMessage());
        }
    }
}
