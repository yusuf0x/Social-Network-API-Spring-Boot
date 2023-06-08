package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

//    @NotNull
    private String title;

//    @NotNull
    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;




    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated_at;

}
