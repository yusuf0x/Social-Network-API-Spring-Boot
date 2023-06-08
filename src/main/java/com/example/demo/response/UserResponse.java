package com.example.demo.response;

import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long uid;
    private String username;
    private String email;
    private List<UserFollowerResponse> followers;
    private List<UserFollowingResponse> following;

    public  static  UserResponse fromEntity(User user){
        if(user==null){
            return null;
        }
        return UserResponse.builder()
                .uid(user.getUid())
                .username(user.getFirstname()+" "+user.getLastname())
                .email(user.getEmail())
                .followers(user.getFollowers().stream().map(UserFollowerResponse::fromEntity).toList())
                .following(user.getFollowing().stream().map(UserFollowingResponse::fromEntity).toList())
                .build();
    }
}
