package com.uzenetesztek.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @GeneratedValue
    @Id
    @ToString.Include
    private Long id;

    @NonNull
    @Column(columnDefinition = "TEXT")
    @ToString.Include
    private String textContent;

    @Column(columnDefinition = "TEXT")
    @ToString.Include
    private String file;

    @NonNull
    @ToString.Include
    private Date timestamp;

    @NonNull
    @ManyToOne          // many posts but only one user per post
    @ToString.Include
    private User user;

    @NonNull
    @ManyToOne
    private Topic parentTopic;

    @ManyToOne
    private Post starterPost;

    @OneToMany(mappedBy = "starterPost")    // each post can have many replies
    private Set<Post> replyPosts;

    @ManyToMany
    private Set<User> userLikes;
}
