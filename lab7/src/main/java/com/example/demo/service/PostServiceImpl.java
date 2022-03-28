package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRep postRep;
    public PostServiceImpl(PostRep postRep) {
        this.postRep = postRep;
    }

    @Override
    public List<Post> postList(){return postRep.findAll();}

    @Override
    public void creatPost(Post post) {
        postRep.save(post);
    }

    @Override
    public void deletePost(Long id){postRep.deleteById(id);}

    @Override
    public Post updateById(Long id){
        return postRep.findById(id).get();
    }



}
