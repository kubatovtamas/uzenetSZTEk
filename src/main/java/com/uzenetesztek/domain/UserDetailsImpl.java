package com.uzenetesztek.domain;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

//    private static final long serialVersionUID = 6529685098267757690L;      // circumvent error

    private User user;
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private Date dateOfBirth;
//    private Date lastLogin;
//    private String email;
//    private String password;
//    private String authority;
//    private String profilePicture;
//    private Set<Post> posts;
//
//    private Set<Topic> topics;
//    private Set<User> follows;
//    private Set<User> followers;
//    private Set<Topic> followTopics;
//    private Set<Post> likedPosts;


    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(User entity) {
        user = entity;
//        authority =  entity.getAuthority();
//        dateOfBirth =entity.getDateOfBirth();
//        email = entity.getEmail();
//        firstName = entity.getFirstName();
//        lastName = entity.getLastName();
//        followers = entity.getFollowers();
//        follows = entity.getFollows();
//        followTopics = entity.getFollowTopics();
//        likedPosts = entity.getLikedPosts();
//        topics = entity.getTopics();
//        profilePicture = entity.getProfilePicture();
//        posts = entity.getPosts();
//        lastLogin = entity.getLastLogin();
//        password = entity.getPassword();

//        authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(entity.getAuthority()));

        this.authorities = Arrays.stream(user.getAuthority().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {       // we authenticate by email
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
