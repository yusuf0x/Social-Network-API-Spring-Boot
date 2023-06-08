package com.example.demo.services;

import com.example.demo.models.Like;
import com.example.demo.repositories.LikeRepository;
import com.example.demo.requests.LikeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<LikeResponse> getAllLikeByPostId(Long postId){
        List<Like> likes = likeRepository.findAllByPostId(postId);
        return likes.stream().map(LikeResponse::fromEntity).toList();
    }
    public List<LikeResponse> getAllLikeByUserId(Long userId){
        List<Like> likes = likeRepository.findAllByUserId(userId);
        return likes.stream().map(LikeResponse::fromEntity).toList();
    }
    public boolean isLiked(Long userId,Long postId){
        Optional<Like> like = likeRepository.findLikesByUserIdAndPostId(userId,postId);
        return like.isPresent();
    }
    public void save(LikeRequest likeRequest){
        if (isLiked(likeRequest.getUserId(), likeRequest.getPostId())){
            return;
        }
        Like like = LikeRequest.toEntity(likeRequest);
        likeRepository.save(like);
    }

    public void delete(LikeRequest likeRequest){
        Optional<Like> like = likeRepository.findLikesByUserIdAndPostId(likeRequest.getUserId(),likeRequest.getPostId());
        likeRepository.delete(like.get());
    }
}
