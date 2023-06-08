package com.example.demo.services;

import com.example.demo.models.Relationship;
import com.example.demo.models.User;
import com.example.demo.repositories.RelationshipRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.requests.UserAddRequest;
import com.example.demo.response.UserFollowingResponse;
import com.example.demo.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;

    public UserService(UserRepository userRepository, RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.relationshipRepository = relationshipRepository;
    }
    public List<UserResponse> getAll(){
        return userRepository.findAll().stream().map(
                UserResponse::fromEntity
        ).toList();
    }
    public UserResponse getUserById(Long id){
        return UserResponse.fromEntity(userRepository.findById(id).orElseThrow());
    }
    public UserResponse getByEmail(String email){
        User user = userRepository.findByEmail(email);
        return UserResponse.fromEntity(user);
    }

    public List<UserFollowingResponse> getUserFollowing(Long userId){
        return relationshipRepository.findAllByUserUid(userId).stream().map(UserFollowingResponse::fromEntity).toList();
    }
    public boolean isFollowing(Long userId,Long followingId){
        Optional<Relationship> follow = relationshipRepository.findByUserUidAndFollowingUid(userId,followingId);
//        System.out.println(follow.get().getUser());
        return follow.isPresent();
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }
    public void add(UserAddRequest userAddRequest){
        User user = userAddRequest.toEntity(userAddRequest);
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
