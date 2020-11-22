package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


//@Scope("session") // Only one instance per session
@Entity
@ToString
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @GeneratedValue
    @Id
    private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @NonNull
    private Date timestamp;

    @NonNull
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
