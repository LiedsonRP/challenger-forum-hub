package br.alura.forumhub.domain.dto.topic;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewTopicDataDTO(
    @NotBlank String title,
    @NotBlank String message,
    @JsonAlias("author_id") @NotNull Long authorId,
    @JsonAlias("course_id") @NotNull Long courseId
) {
}
