package com.example.demo.dto;

import java.util.List;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserPostResponse {
    @JsonIgnoreProperties({"posts"})
    private User user;
    @JsonIgnoreProperties({"user"})
    private List<Post> posts;

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

