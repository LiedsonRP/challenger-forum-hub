package br.alura.forumhub.model;

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
@Table(name = "topics")
/**
 * Entidade que representa uma resposta de uma pergunta para o Forum
 */
public class TopicAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private ForumTopic topic;
    private LocalDateTime createdAt;
    private User author;
    private Boolean solution;
}
