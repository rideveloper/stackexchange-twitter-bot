package com.rideveloper.stackexchangeclient.repo;

import com.rideveloper.stackexchangeclient.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ridwan Mustapha
 */
public interface QuestionTweetRepo extends JpaRepository<Tweet, Long> {

}
