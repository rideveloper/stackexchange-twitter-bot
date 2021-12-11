package com.rideveloper.stackexchangeclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Tweet {

    @Id
    private long questionId;
    private LocalDateTime tweetTimestamp;

}
