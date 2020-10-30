package com.uzenetesztek.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
public class Topic {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    private String name;

    @ManyToOne
    private Topic parent;

    // One Topic can has more than 1 posts, but a post has just one parent topic
    @OneToMany(mappedBy = "parentTopic")
    private List<Post> posts;

    // One user can make many topic, but a topic is made by one user
    @ManyToOne
    private User user;
}
