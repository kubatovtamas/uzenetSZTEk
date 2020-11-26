package com.uzenetesztek.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Entity
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of="id")
@Getter
@Setter
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue
    @Id
    @ToString.Include
    private Long id;

    @NotBlank(message = "First Name Cannot Be Blank")
    @ToString.Include
    private String firstName;

    @NotBlank(message = "Last Name Cannot Be Blank")
    @ToString.Include
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ToString.Include
    private Date dateOfBirth;

    @ToString.Include
    private Date lastLogin;

    @NotNull
    @Column(unique = true, nullable = false)      // only one user per username
    @ToString.Include
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ToString.Include
    private String authority;

    private String activation;

    private Boolean enabled;

    @Column(columnDefinition = "TEXT")
    private String profilePicture;

    @OneToMany(mappedBy = "user")               // one user can have many posts, mapped by Post.user object's id
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")               // one user can have many topics, mapped by Topic.user object's id
    private Set<Topic> topics;                  // each topic is unique in this list

    @ManyToMany
    private Set<User> follows;                  // people we follow

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
