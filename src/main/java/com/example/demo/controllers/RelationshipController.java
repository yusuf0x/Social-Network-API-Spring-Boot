package com.example.demo.controllers;

import com.example.demo.requests.RelationshipRequest;
import com.example.demo.services.RelationshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/relationships")
public class RelationshipController {
    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody RelationshipRequest relationshipRequest){
        relationshipService.save(relationshipRequest);
        return new ResponseEntity<>("Followed", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody RelationshipRequest  relationshipRequest){
        relationshipService.delete(relationshipRequest);
        return new ResponseEntity<>("Unfollowed",HttpStatus.OK);
    }

}
