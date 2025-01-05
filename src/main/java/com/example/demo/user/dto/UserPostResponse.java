package com.example.demo.user.dto;

import java.util.List;

import com.example.demo.post.entity.Post;
import com.example.demo.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserPostResponse {
    @JsonIgnoreProperties({"posts"})
    private User user;
    @JsonIgnoreProperties({"user"})
    private List<Post> posts;

    // Constructors, Getters, and Setters
    public UserPostResponse(User user, List<Post> posts) {
        this.user = user;
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

