package com.example.demo.repositories;


import com.example.demo.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
    @Query(value = "SELECT * FROM likes WHERE user_id = :userId",nativeQuery = true)
    List<Like> findAllByUserId(@Param("userId") Long userId);
    @Query(value = "SELECT * FROM likes WHERE post_id = :postId",nativeQuery = true)
    List<Like> findAllByPostId(@Param("postId") Long postId);

    @Query(value = "SELECT * FROM likes WHERE post_id = :postId And user_id = :userId",nativeQuery = true)
    Optional<Like> findLikesByUserIdAndPostId(@Param("userId") Long userId,@Param("postId") Long postId);
    void deleteById(Long uid);
}
