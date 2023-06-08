package com.example.demo.controllers;

import com.example.demo.requests.CommentAddRequest;
import com.example.demo.response.CommentResponse;
import com.example.demo.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments/")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/getall")
    public ResponseEntity<List<CommentResponse>> getAll(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> getAllByPostId(@PathVariable Long postId){
        return new ResponseEntity<>(commentService.getAllByPostId(postId),HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentResponse>> getAllByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(commentService.getAllByUserId(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CommentAddRequest commentAddRequest){
        commentService.saveComment(commentAddRequest);
        return new ResponseEntity<>("Comment Created ",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<>("Comment Deleted",HttpStatus.OK);
    }
}
