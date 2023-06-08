package com.example.demo.requests;


import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class UserAddRequest {
    private String firstname;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Autowired
    private  PasswordEncoder passwordEncoder;

//    public UserAddRequest(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public User toEntity(UserAddRequest userAddRequest){
        if(userAddRequest == null){
            return null;
        }
        User user = new User();
        user.setFirstname(userAddRequest.firstname);
        user.setLastname(userAddRequest.lastName);
        user.setEmail(userAddRequest.email);
        user.setUsername(userAddRequest.getUsername());
        user.setPassword(userAddRequest.password);
//        user.setPassword(passwordEncoder.encode(userAddRequest.getPassword()));
        return user;
    }
}