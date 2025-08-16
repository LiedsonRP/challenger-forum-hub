package br.alura.forumhub.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "topic_answers")
/**
 * Entidade que representa uma resposta de uma pergunta para o Forum
 */
public class TopicAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private ForumTopic topic;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile author;

    @Column(nullable = false)
    private Boolean solution;
}
