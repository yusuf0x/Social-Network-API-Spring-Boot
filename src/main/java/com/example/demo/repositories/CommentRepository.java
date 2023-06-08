package com.example.demo.repositories;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "SELECT * FROM comments WHERE user_id = :userId",nativeQuery = true)
    List<Comment> findAllByUserId(@Param("userId") Long userId);
    @Query(value = "SELECT * FROM comments WHERE post_id = :postId",nativeQuery = true)
    List<Comment> findAllByPostId(@Param("postId") Long postId);
    void deleteById(Long uid);
}
