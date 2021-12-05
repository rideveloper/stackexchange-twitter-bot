package com.rideveloper.stackexchangeclient.model.response;

import lombok.Data;

import java.util.List;

/**
 * @author Ridwan Mustapha
 */
@Data
public class QuestionResponse {

    private List<Item> items;

    @Data
    public static class Item {
        private boolean is_answered;
        private int view_count;
        private int answer_count;
        private int score;
        private long question_id;
        private String link;
        private String title;
        private Owner owner;
    }

    @Data
    public static class Owner {
        private int reputation;
        private int user_id;
    }
}
