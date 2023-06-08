package com.example.demo.repositories;

import com.example.demo.models.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship,Long> {
    List<Relationship> findAllByUserUid(Long userId);
    @Query(name = "SELECT * FROM relationships WHERE user_following_id =:followingId and user_id =:userId ",nativeQuery = true)
    Optional<Relationship> findByUserUidAndFollowingUid(Long userId, Long followingId);
}
