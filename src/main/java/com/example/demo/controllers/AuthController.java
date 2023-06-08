package com.example.demo.controllers;

import com.example.demo.config.JwtService;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.requests.LoginRequest;
import com.example.demo.requests.RegisterRequest;
import com.example.demo.response.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @PostMapping("/register")
    public  ResponseEntity<?> register(@RequestBody RegisterRequest request){
        if (userRepository.findByEmail(request.getEmail())!=null){
            return new ResponseEntity<>("Email already exist", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        return new ResponseEntity<>(AuthResponse.builder().token(jwtService.generateToken(
                request.getEmail(),
                userRepository.findByEmail(request.getEmail()).getUid(),
                request.getFirstname() +" "+request.getLastname()
        )).build(),HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
            try{
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getEmail(),
                                loginRequest.getPassword()
                        )
                );
                return new ResponseEntity<>(AuthResponse.builder().token(
                        jwtService.generateToken(
                                loginRequest.getEmail(),
                                userRepository.findByEmail(loginRequest.getEmail()).getUid(),
                                userRepository.findByEmail(loginRequest.getEmail()).getFirstname()+" "+
                                userRepository.findByEmail(loginRequest.getEmail()).getLastname()
                                )
                ).build(),HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
    }
}
