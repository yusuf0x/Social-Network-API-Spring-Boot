package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "relationships")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_following_id")
    private User following;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
