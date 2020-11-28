package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


//@Scope("session") // Only one instance per session
@Entity
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @GeneratedValue
    @Id
    @ToString.Include
    private Long id;

    @NonNull
    @Column(unique = true)
    @ToString.Include
    private String name;

    @NonNull
    @ToString.Include
    private Date timestamp;

    @NonNull
    @Column(columnDefinition = "TEXT")
    @ToString.Include
    private String description;

    // One Topic can have more than 1 post, but a post has just one parent topic
    @OneToMany(mappedBy = "parentTopic")
    private Set<Post> posts;

    // One user can make many topics, but a topic is made by one user
    @NonNull
    @ManyToOne
    @ToString.Include
    private User user;

    // User - Topics follows
    @ManyToMany
    private Set<User> followers;            //  unique followers per topic


    public void addFollower(User user) {
        if(followers.contains(user)) return;

        followers.add(user);
    }
}
