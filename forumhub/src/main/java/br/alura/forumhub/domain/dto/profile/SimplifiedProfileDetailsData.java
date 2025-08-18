package br.alura.forumhub.domain.dto.profile;

import br.alura.forumhub.domain.model.Profile;

public record SimplifiedProfileDetailsData (
        Long id,
        String name
) {

    public SimplifiedProfileDetailsData(Profile profile) {
        this(profile.getId(), profile.getName());
    }
}
