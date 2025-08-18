package br.alura.forumhub.domain.dto.topic;

import br.alura.forumhub.domain.dto.profile.SimplifiedProfileDetailsData;
import br.alura.forumhub.domain.model.ForumTopic;
import br.alura.forumhub.domain.model.Status;

import java.time.LocalDateTime;

public record TopicListDetailDTO(
    Long id,
    String title,
    SimplifiedProfileDetailsData author,
    Status status,
    LocalDateTime createdAt
)
{
    public TopicListDetailDTO(ForumTopic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                new SimplifiedProfileDetailsData(topic.getAuthor()),
                topic.getStatus(),
                topic.getCreatedAt()
        );
    }
}
