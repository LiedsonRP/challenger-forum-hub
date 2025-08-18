package br.alura.forumhub.domain.dto.Topic;

import br.alura.forumhub.domain.model.Course;
import br.alura.forumhub.domain.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTopicInfoDTO(
    @NotNull Long topic_id,
    String title,
    String message,
    Status status,
    Course course
)
{}
