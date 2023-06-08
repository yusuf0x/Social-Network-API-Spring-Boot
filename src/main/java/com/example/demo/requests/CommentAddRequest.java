package com.example.demo.requests;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentAddRequest {
    private Long postId;
    private Long userId;
    private String comment;

    public  static Comment fromEntity(CommentAddRequest commentAddRequest){
        if(commentAddRequest==null){
            return null;
        }
        Comment comment1 = new Comment();
        comment1.setComment(commentAddRequest.getComment());
        comment1.setUser(User.builder().uid(commentAddRequest.userId).build());
        comment1.setPost(Post.builder().uid(commentAddRequest.postId).build());
        return  comment1;
    }

}
