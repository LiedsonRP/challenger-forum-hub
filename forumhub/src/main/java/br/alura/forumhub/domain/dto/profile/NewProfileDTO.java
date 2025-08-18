package br.alura.forumhub.domain.dto.profile;

import jakarta.validation.constraints.NotNull;

public record NewProfileDTO(
        @NotNull String name
) {
}
