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
public class UserFollowerResponse {
    private Long userId;
    private String name;
    private String username;
    public  static  UserFollowerResponse fromEntity(Relationship relationship){
        if(relationship==null){
            return null;
        }
        return UserFollowerResponse.builder()
                .userId(relationship.getUser().getUid())
                .name(relationship.getUser().getFirstname()+" "+relationship.getUser().getLastname())
                .build();
    }
}
