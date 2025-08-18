package br.alura.forumhub.domain.dto.topic_answer;

import br.alura.forumhub.domain.dto.profile.SimplifiedProfileDetailsData;
import br.alura.forumhub.domain.model.TopicAnswer;

import java.time.LocalDateTime;

public record SimplifiedAnswerData(
        Long id,
        String message,
        LocalDateTime createdAt,
        SimplifiedProfileDetailsData author,
        Boolean solution
) {
    public SimplifiedAnswerData(TopicAnswer answer) {
        this(
                answer.getId(),
                answer.getMessage(),
                answer.getCreatedAt(),
                new SimplifiedProfileDetailsData(answer.getAuthor()),
                answer.getSolution()
        );
    }
}
