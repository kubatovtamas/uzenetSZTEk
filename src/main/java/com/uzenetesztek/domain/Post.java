package com.uzenetesztek.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity         // for hibernate
//@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
@Getter @Setter @ToString @RequiredArgsConstructor
public class Post {
    @GeneratedValue
    @Id                 // primary key
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column(columnDefinition = "TEXT")
    private String file;
    private Date timestamp;


    @ManyToOne          // many posts but only one user per post
    private User user;

    @ManyToOne
    private Topic parentTopic;

    // sel join part
    @ManyToOne
    private Post starterPost;

    @OneToMany(mappedBy = "starterPost")          // each post can have many replies
    private Set<Post> replyPosts;

    @ManyToMany
    private Set<Post> userLikes;
}
