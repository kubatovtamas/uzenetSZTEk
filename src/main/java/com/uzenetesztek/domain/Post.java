package com.uzenetesztek.domain;


import lombok.Data;

import javax.persistence.*;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
public class Post {
    @GeneratedValue
    @Id                 // primary key
    private long postid;
    private String text_content;
    @ManyToOne          // many posts but only one user per post
    private User user;
}
