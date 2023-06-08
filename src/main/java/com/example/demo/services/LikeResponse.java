package com.example.demo.services;

import com.example.demo.models.Like;
import com.example.demo.models.Post;
import com.example.demo.response.PostResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponse {
    private Long id;
    private Long userId;
    private Long postId;
    private String username;

    public  static LikeResponse fromEntity(Like like){
        if(like==null){
            return null;
        }
        return LikeResponse.builder()
                .id(like.getUid())
                .userId(like.getUser().getUid())
                .postId(like.getPost().getUid())
                .username(like.getUser().getFirstname()+" "+like.getUser().getLastname())
                .build();
    }
}
