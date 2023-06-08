package com.example.demo.response;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJwtResponse {
    private Long id;
    private String username;
    private String email;
    private String fullname;
}