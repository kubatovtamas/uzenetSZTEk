package com.uzenetesztek.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
public class Post {
    @GeneratedValue
    @Id                 // primary key
    private Long postid;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column(columnDefinition = "TEXT")
    private String file;
    private Date timestamp;

    @ManyToOne          // many posts but only one user per post
    private User user;
}
