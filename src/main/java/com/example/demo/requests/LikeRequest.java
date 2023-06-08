package com.example.demo.requests;

import com.example.demo.models.Like;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeRequest {
    private Long postId;
    private Long userId;

    public static Like toEntity(LikeRequest likeRequest){
        if(likeRequest==null){
            return null;
        }
        Like like = new Like();
        like.setUser(User.builder().uid(likeRequest.userId).build());
        like.setPost(Post.builder().uid(likeRequest.postId).build());
        return like;
    }
}
