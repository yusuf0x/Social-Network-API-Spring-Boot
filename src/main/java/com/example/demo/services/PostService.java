package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import com.example.demo.requests.InsertPostRequest;
import com.example.demo.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<PostResponse> getAll(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(
                PostResponse::fromEntity
        ).toList();
    }
    public PostResponse getPostById(Long id){
        Post post = postRepository.findById(id).orElse(null);
        return PostResponse.fromEntity(post);
    }
    public List<PostResponse> getPostByUserIdById(Long id){
        List<Post> posts = postRepository.findAllByUserId(id);
        return posts.stream().map(PostResponse::fromEntity).toList();
    }
    public Post getById(Long id){
        return postRepository.findById(id).get();
    }
    public Long add(InsertPostRequest insertPostRequest){
         Post post = InsertPostRequest.toEntity(insertPostRequest);
        postRepository.save(post);
        return post.getUid();
    }
    public void delete(Long id){
        postRepository.deleteById(id);
    }

//    public List<PostResponse> getByUser
}
