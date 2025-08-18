package br.alura.forumhub.domain.dto.course;

import br.alura.forumhub.domain.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewCourseData(
    @NotBlank String name,
    @NotNull Category category
) {
}
