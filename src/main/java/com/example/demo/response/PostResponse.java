package com.example.demo.response;

import com.example.demo.models.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private Long uid;
    private Long userId;
    private String title;
    private String description;
    private  String  image;
    public  static  PostResponse fromEntity(Post post){
        if(post==null){
            return null;
        }
        return PostResponse.builder()
                .uid(post.getUid())
                .userId(post.getUser().getUid())
                .description(post.getDescription())
                .title(post.getTitle())
                .image(post.getImage())
                .build();
    }
}

