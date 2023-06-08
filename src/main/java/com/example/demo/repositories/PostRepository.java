package com.example.demo.repositories;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query(value = "SELECT * FROM posts WHERE user_id = :userId",nativeQuery = true)
    List<Post> findAllByUserId(@Param("userId") Long userId);
    void deleteById(Long uid);

}
