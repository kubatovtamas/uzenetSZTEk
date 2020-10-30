package com.uzenetesztek.domain;

import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.Entity;        // for hibernate
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity         // for hibernate
@Data           // getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
public class User {
    @GeneratedValue
    @Id         // primary key
    private long id;

    private String name;
    private String email;
    private Date dob; // date of birth

    // User Posts
    @OneToMany(mappedBy = "user")          // one user can have many posts, mapped by Post.user field
    private List<Post> posts;

}
