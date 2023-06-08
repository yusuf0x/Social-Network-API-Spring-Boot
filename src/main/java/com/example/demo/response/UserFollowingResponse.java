package com.example.demo.response;
import com.example.demo.models.Relationship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollowingResponse {
    private Long userId;
    private String name;
//    private String username;
    public  static  UserFollowingResponse fromEntity(Relationship relationship){
        if(relationship==null){
            return null;
        }
        return UserFollowingResponse.builder()
                .userId(relationship.getUser().getUid())
                .name(relationship.getUser().getFirstname()+" "+relationship.getUser().getLastname())
                .build();
    }
}
