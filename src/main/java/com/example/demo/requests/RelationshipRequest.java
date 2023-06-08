package com.example.demo.requests;

import com.example.demo.models.Relationship;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelationshipRequest {
    private Long userId;
    private Long followingId;

    public static Relationship toEntity(RelationshipRequest relationshipRequest){
        if(relationshipRequest==null){
            return null;
        }
        Relationship relationship = new Relationship();
        relationship.setUser(User.builder().uid(relationshipRequest.userId).build());
        relationship.setFollowing(User.builder().uid(relationshipRequest.followingId).build());
        return relationship;
    }
}
