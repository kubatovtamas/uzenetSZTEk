package com.uzenetesztek.domain;

import com.uzenetesztek.controller.HomeController;
import com.uzenetesztek.repository.PostRepository;
import com.uzenetesztek.service.TopicService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.*;

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
    @Column(columnDefinition = "TEXT")
    private String description;

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
