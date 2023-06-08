package com.example.demo.controllers;

import com.example.demo.requests.LikeRequest;
import com.example.demo.services.LikeResponse;
import com.example.demo.services.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLike(@RequestBody LikeRequest likeRequest){
        likeService.save(likeRequest);
        return new ResponseEntity<>("like added", HttpStatus.OK);
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<LikeResponse>> getAllLikesByPostId(@PathVariable Long postId){
        return new ResponseEntity<>(likeService.getAllLikeByPostId(postId), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikeResponse>> getAllLikesByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(likeService.getAllLikeByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("/isliked")
    public ResponseEntity<Boolean> isLiked(@RequestParam Long userId,@RequestParam Long postId){
        return new ResponseEntity<>(likeService.isLiked(userId,postId),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody LikeRequest likeRequest){
        likeService.delete(likeRequest);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
