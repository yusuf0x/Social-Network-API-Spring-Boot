package com.example.demo.response;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private Long postId;
    private Long userId;
    private String comment;
    public  static  CommentResponse fromEntity(Comment comment){
        if(comment==null){
            return null;
        }
        return CommentResponse.builder()
                .id(comment.getUid())
                .postId(comment.getPost().getUid())
                .userId(comment.getUser().getUid())
                .comment(comment.getComment())
                .build();
    }
}
