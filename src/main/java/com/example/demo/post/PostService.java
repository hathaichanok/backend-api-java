package com.example.demo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.post.entity.Post;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public List<Post> getPostByUserId(Long id) {
        return postRepository.findByUserId(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    public Post patchPost(Long id, Post partialPost) {
        Post existingPost = getPostById(id);
        if (partialPost.getTitle() != null) {
            existingPost.setTitle(partialPost.getTitle());
        }
        if (partialPost.getBody() != null) {
            existingPost.setBody(partialPost.getBody());
        }
        return postRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> filterPostsByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }
}
