package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stories")
public class Stories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String media;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
