package com.uzenetesztek.domain;

import lombok.*;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "user")          // one user can have many posts, mapped by Topic.user object's id
    private List<Topic> topics;

}
