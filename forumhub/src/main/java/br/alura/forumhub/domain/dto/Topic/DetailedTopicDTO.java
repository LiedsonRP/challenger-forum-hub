package br.alura.forumhub.domain.dto.topic;

import java.time.LocalDateTime;

import br.alura.forumhub.domain.dto.profile.SimplifiedProfileDetailsData;
import br.alura.forumhub.domain.dto.topic_answer.SimplifiedAnswerData;
import br.alura.forumhub.domain.model.ForumTopic;
import br.alura.forumhub.domain.model.Status;

import java.util.List;

public record DetailedTopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        Status status,
        SimplifiedProfileDetailsData author,
        List<SimplifiedAnswerData> answers
) {

    public DetailedTopicDTO(ForumTopic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getStatus(),
                new SimplifiedProfileDetailsData(topic.getAuthor()),
                topic.getAnswers().stream()
                        .map(SimplifiedAnswerData::new)
                        .toList()
        );
    }
}
