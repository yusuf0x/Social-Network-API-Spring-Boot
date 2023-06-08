package com.example.demo.services;

import com.example.demo.models.Relationship;
import com.example.demo.repositories.RelationshipRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.requests.RelationshipRequest;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {
    private final RelationshipRepository relationshipRepository;
    private final UserService userService;

    public RelationshipService(RelationshipRepository relationshipRepository, UserService userService) {
        this.relationshipRepository = relationshipRepository;
        this.userService = userService;
    }

    public void save(RelationshipRequest relationshipRequest){
        if (userService.isFollowing(relationshipRequest.getUserId(), relationshipRequest.getFollowingId())){
            return;
        }
        relationshipRepository.save(
                RelationshipRequest.toEntity(relationshipRequest)
        );
    }

    public  void delete(RelationshipRequest relationshipRequest){
        Relationship follow = relationshipRepository.findByUserUidAndFollowingUid(
                relationshipRequest.getUserId(), relationshipRequest.getFollowingId()
        ).orElse(null);
        relationshipRepository.delete(follow);
    }
}
