package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.requests.CommentAddRequest;
import com.example.demo.requests.CommentUpdateRequest;
import com.example.demo.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public void saveComment(CommentAddRequest commentAddRequest){
        Comment comment = CommentAddRequest.fromEntity(commentAddRequest);
        commentRepository.save(comment);
    }

    public List<CommentResponse> getAll(){
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentResponse::fromEntity).toList();
    }

    public CommentResponse getById(Long id){
        Comment comment = commentRepository.findById(id).orElse(null);
        return  CommentResponse.fromEntity(comment);
    }
    public List<CommentResponse> getAllByPostId(Long postId){
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        return comments.stream().map(CommentResponse::fromEntity).toList();
    }
    public List<CommentResponse> getAllByUserId(Long userId){
        List<Comment> comments = commentRepository.findAllByUserId(userId);
        return comments.stream().map(CommentResponse::fromEntity).toList();
    }
    public void update(Long id, CommentUpdateRequest commentUpdateRequest){
        Comment commentToUpdate = commentRepository.findById(id).orElse(null);
        if (commentToUpdate!=null){
            commentToUpdate.setComment(commentUpdateRequest.getComment());
        }
    }
    public void delete(Long id){
        commentRepository.deleteById(id);
    }
}
