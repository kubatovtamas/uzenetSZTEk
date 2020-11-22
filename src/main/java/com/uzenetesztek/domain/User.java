package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue
    @Id         // primary key
    private Long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Date lastLogin;

    @NonNull
    @Column(unique = true)                      // only one user per username
    private String email;

    @NonNull
    private String password;

    @NonNull
    private boolean isAdmin;

    @Column(columnDefinition = "TEXT")
    private String profilePicture;

    @OneToMany(mappedBy = "user")               // one user can have many posts, mapped by Post.user object's id
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")               // one user can have many topics, mapped by Topic.user object's id
    private Set<Topic> topics;                  // each topic is unique in this list

    @ManyToMany
    private List<User> follows;

    @ManyToMany(mappedBy = "follows")           // user can follow other people and it's true backwards as well
    private Set<User> followees;                // can't follow the same person twice

    @ManyToMany
    private Set<Topic> followTopics;

    @ManyToMany(mappedBy = "userLikes")
    private Set<Post> likedPosts;               // only one like per post per user

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
