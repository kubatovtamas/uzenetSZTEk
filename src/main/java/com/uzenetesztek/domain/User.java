package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue
    @Id         // primary key
    @ToString.Include
    private Long id;

    @ToString.Include
    private String firstName;

    @ToString.Include
    private String lastName;

    @ToString.Include
    private Date dateOfBirth;

    @ToString.Include
    private Date lastLogin;

    @NonNull
    @Column(unique = true)                      // only one user per username
    @ToString.Include
    private String email;

    @NonNull
    private String password;

    @NonNull
    @ToString.Include
    private boolean isAdmin;

    @Column(columnDefinition = "TEXT")
    private String profilePicture;

    @OneToMany(mappedBy = "user")               // one user can have many posts, mapped by Post.user object's id
    @ToString.Exclude
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")               // one user can have many topics, mapped by Topic.user object's id
    private Set<Topic> topics;                  // each topic is unique in this list

    @ManyToMany
    private Set<User> follows;                 // people we follow

    @ManyToMany(mappedBy = "follows")           // user can follow other people and it's true backwards as well
    private Set<User> followers;                // people who follow us

    @ManyToMany
    private Set<Topic> followTopics;

    @ManyToMany(mappedBy = "userLikes")
    private Set<Post> likedPosts;               // only one like per post per user

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
