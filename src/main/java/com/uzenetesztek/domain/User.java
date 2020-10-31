package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
public class User {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth; // date of birth
    private Date lastLogin;
    private String email;
    private String password;
    private boolean isAdmin;
    @Column(columnDefinition = "TEXT")
    private String profilePicture;


    // User Posts
    @OneToMany(mappedBy = "user")          // one user can have many posts, mapped by Post.user object's id
    private List<Post> posts;

    // User Topics
    @OneToMany(mappedBy = "user")          // one user can have many topics, mapped by Topic.user object's id
    private List<Topic> topics;

    // User User
    @ManyToMany
    private List<User> follows;
    @ManyToMany(mappedBy = "follows")      // user can follow other people and it's true backwards as well
    private List<User> followees;

    // User Topics
    @ManyToMany
    private List<Topic> followTopics;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
