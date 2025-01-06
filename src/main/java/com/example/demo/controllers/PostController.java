package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Post;
import com.example.demo.services.PostService;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/posts")
class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Post> posts = postService.getAllPosts(pageable);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return ResponseEntity.ok(updatedPost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @RequestBody Post partialPost) {
        Post patchedPost = postService.patchPost(id, partialPost);
        return ResponseEntity.ok(patchedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post id " + id + " was deleted");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Post>> filterPosts(@RequestParam String title) {
        List<Post> filteredPosts = postService.filterPostsByTitle(title);
        return ResponseEntity.ok(filteredPosts);
    }
}
