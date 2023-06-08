package com.example.demo.controllers;

import com.example.demo.requests.UserAddRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserResponse>> getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/isfollowing")
    public ResponseEntity<Boolean> isFollowing(@RequestParam Long userId,@RequestParam Long followingId){
        return new ResponseEntity<>(userService.isFollowing(userId,followingId),HttpStatus.OK);
    }
//
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody UserAddRequest userAddRequest){
        userService.add(userAddRequest);
        return new ResponseEntity<>("User Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
