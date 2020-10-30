package com.uzenetesztek.domain;

import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
public class User {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob; // date of birth
    private Date lastLogin;
    private String email;
    private String password;
    private boolean isAdmin;
    @Column(columnDefinition = "TEXT")
    private String profilePicture;

    // User Posts
    @OneToMany(mappedBy = "user")          // one user can have many posts, mapped by Post.user field
    private List<Post> posts;
}
