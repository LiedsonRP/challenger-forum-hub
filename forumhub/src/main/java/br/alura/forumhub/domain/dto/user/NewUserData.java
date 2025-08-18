package br.alura.forumhub.domain.dto.user;

import br.alura.forumhub.domain.dto.profile.NewProfileDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record NewUserData(
        @NotNull String name,
        @NotNull @Email String email,
        @NotNull String password,
        @JsonAlias("new_profile") @NotNull @Valid NewProfileDTO newProfileData
) {
}
