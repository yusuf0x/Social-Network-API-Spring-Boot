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

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotNull
    private String comment;

    @Column(columnDefinition = "BOOL DEFAULT 0")
    private Boolean is_like;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated_at;

}
