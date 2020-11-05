package com.uzenetesztek.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {
    @GeneratedValue
    @Id
    private Long id;
    @NonNull
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column(columnDefinition = "TEXT")
    private String file;
    @NonNull
    private Date timestamp;

    @NonNull
    @ManyToOne          // many posts but only one user per post
    private User user;

    @NonNull
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
