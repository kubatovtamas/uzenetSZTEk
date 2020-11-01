package com.uzenetesztek.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
@NoArgsConstructor
@RequiredArgsConstructor
public class Topic {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    @NonNull
    @Column(unique=true)
    private String name;
    @NonNull
    private Date timestamp;

    // One Topic can have more than 1 post, but a post has just one parent topic
    @OneToMany(mappedBy = "parentTopic")
    private Set<Post> posts;

    // One user can make many topics, but a topic is made by one user
    @NonNull
    @ManyToOne
    private User user;

    // User - Topics follows
    @ManyToMany(mappedBy = "followTopics")
    private Set<User> followers;            //  unique followers per topic

}
