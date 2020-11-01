package com.uzenetesztek.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
public class Topic {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    @Column(unique=true)
    private String name;
    private Date timestamp;

    // One Topic can have more than 1 post, but a post has just one parent topic
    @OneToMany(mappedBy = "parentTopic")
    private Set<Post> posts;

    // One user can make many topics, but a topic is made by one user
    @ManyToOne
    private User user;

    // User - Topics follows
    @ManyToMany(mappedBy = "followTopics")
    private Set<User> followers;            //  unique followers per topic

}
