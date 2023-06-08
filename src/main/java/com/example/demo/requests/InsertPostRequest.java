package com.example.demo.requests;

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
public class InsertPostRequest {
    private  Long userId;
    private  String title;
    private  String description;
    private  String image;
    public  static Post toEntity(InsertPostRequest insertPostRequest){
        if(insertPostRequest==null){
            return null;
        }
        Post post = new Post();
        post.setUser(User.builder().uid(insertPostRequest.userId).build());
        post.setDescription(insertPostRequest.description);
        post.setTitle(insertPostRequest.title);
        post.setImage(insertPostRequest.image);
        return post;
    }
}
