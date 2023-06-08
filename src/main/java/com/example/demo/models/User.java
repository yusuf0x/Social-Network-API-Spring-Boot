package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
//    @NotNull
    private  String lastname;
//    @NotNull
    private  String firstname;
//    @NotNull
    private  String username;
//    @NotNull
    @Email
    private  String email;
//    @NotNull
    private  String password;

    private  String coverPic;
    private  String profilePic;
    private  String city;
    private  String phone;
    private  String website;
    @Column(columnDefinition = "BOOL DEFAULT FALSE")
    private  Boolean email_verified;
    private String notification_token;
    private String token_temp;
    private Date birthday_date;
    @Column(columnDefinition = "BOOL DEFAULT 1")
    private Boolean state;
    @Column(columnDefinition = "BOOL DEFAULT FALSE")
    private Boolean is_private;
    @Column(columnDefinition = "BOOL DEFAULT FALSE")
    private Boolean is_online;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Relationship> following;

    @OneToMany(mappedBy = "following",cascade = CascadeType.ALL)
    private List<Relationship> followers;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Stories> stories;



    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
