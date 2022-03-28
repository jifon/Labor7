package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {

    public List<Post> postList();
    public void creatPost(Post post);
    public void deletePost(Long id);
    public Post updateById(Long id);

}
