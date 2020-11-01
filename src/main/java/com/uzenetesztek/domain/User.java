package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity         // for hibernate
//@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
@Getter @Setter @ToString @RequiredArgsConstructor
public class User {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth; // date of birth
    private Date lastLogin;
    @Column(unique=true)        // only one user per username
    private String email;
    private String password;
    private boolean isAdmin;
    @Column(columnDefinition = "TEXT")
    private String profilePicture;


    // User Posts
    @OneToMany(mappedBy = "user")          // one user can have many posts, mapped by Post.user object's id
    private Set<Post> posts;

    // User Topics
    @OneToMany(mappedBy = "user")          // one user can have many topics, mapped by Topic.user object's id
    private Set<Topic> topics;             // each topic is unique in this list

    // User User
    @ManyToMany
    private List<User> follows;
    @ManyToMany(mappedBy = "follows")      // user can follow other people and it's true backwards as well
    private Set<User> followees;            // can't follow the same person twice

    // User Topics
    @ManyToMany
    private Set<Topic> followTopics;

    // Posts Liked by user
    @ManyToMany(mappedBy = "userLikes")
    private Set<Post> likedPosts;       // only one like per post per user

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
