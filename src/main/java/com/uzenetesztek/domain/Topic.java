package com.uzenetesztek.domain;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity         // for hibernate
// getters, setters, toString, equalsHashCode, RequiredArgsConstructor
//@Scope("session") // Only one instance per session
public class Topic {
    @GeneratedValue
    @Id         // primary key
    private Long id;
    @NonNull
    @Column(unique=true)
    private String name;
    @NonNull
    private Date timestamp;
    @NonNull
    @Column(columnDefinition = "TEXT")
    private String description;

    // One Topic can have more than 1 post, but a post has just one parent topic
    @OneToMany(mappedBy = "parentTopic")
    private Set<Post> posts;

    // One user can make many topics, but a topic is made by one user
    @NonNull
    @ManyToOne
    private User user;

    // User - Topics follows
    @ManyToMany(mappedBy = "followTopics")
    private Set<User> followers;            //  unique followers per topic

    public Topic(@NonNull String name, @NonNull Date timestamp, @NonNull String description, @NonNull User user) {
        this.name = name;
        this.timestamp = timestamp;
        this.description = description;
        this.user = user;
    }

    public Topic() {
    }

    public Long getId() {
        return this.id;
    }

    public @NonNull String getName() {
        return this.name;
    }

    public @NonNull Date getTimestamp() {
        return this.timestamp;
    }

    public @NonNull String getDescription() {
        return this.description;
    }

    public Set<Post> getPosts() {
        return this.posts;
    }

    public @NonNull User getUser() {
        return this.user;
    }

    public Set<User> getFollowers() {
        return this.followers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setTimestamp(@NonNull Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public void setUser(@NonNull User user) {
        this.user = user;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Topic)) return false;
        final Topic other = (Topic) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$posts = this.getPosts();
        final Object other$posts = other.getPosts();
        if (this$posts == null ? other$posts != null : !this$posts.equals(other$posts)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$followers = this.getFollowers();
        final Object other$followers = other.getFollowers();
        if (this$followers == null ? other$followers != null : !this$followers.equals(other$followers)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Topic;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $posts = this.getPosts();
        result = result * PRIME + ($posts == null ? 43 : $posts.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $followers = this.getFollowers();
        result = result * PRIME + ($followers == null ? 43 : $followers.hashCode());
        return result;
    }

    public String toString() {
        return "Topic(id=" + this.getId() + ", name=" + this.getName() + ", timestamp=" + this.getTimestamp() + ", description=" + this.getDescription() + ", posts=" + this.getPosts() + ", user=" + this.getUser() + ", followers=" + this.getFollowers() + ")";
    }
}
