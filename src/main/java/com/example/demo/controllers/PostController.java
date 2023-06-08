package com.example.demo.controllers;

import com.example.demo.requests.InsertPostRequest;
import com.example.demo.response.PostResponse;
import com.example.demo.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts/")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/getall")
    public List<PostResponse> getAllPosts(){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }
    @GetMapping("/user/{user_id}")
    public List<PostResponse> getPostByUserId(@PathVariable("user_id") Long id){
        return postService.getPostByUserIdById(id);
    }
//    @GetMapping("/getbyuserfollowing/{userId}")
//    public ResponseEntity<List<PostResponse>> getAllByUserFollowing(@PathVariable int userId){
//        return new ResponseEntity<>(postService.getByUserFollowing(userId),HttpStatus.OK);
//    }

    @PostMapping("/")
    public ResponseEntity<Long> savePost(@RequestBody InsertPostRequest insertPostRequest){
        Long postId = postService.add(insertPostRequest);
        return new ResponseEntity<>(postId, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        try{
            postService.delete(id);
            return new ResponseEntity<>("Post deleted", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("post not found ", HttpStatus.NOT_FOUND);
        }
    }
}
