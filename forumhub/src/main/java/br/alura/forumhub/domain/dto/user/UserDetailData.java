package br.alura.forumhub.domain.dto.user;

import br.alura.forumhub.domain.dto.profile.SimplifiedProfileDetailsData;
import br.alura.forumhub.domain.model.User;

import java.util.List;

public record UserDetailData(
        Long id,
        String name,
        String email,
        List<SimplifiedProfileDetailsData> profileList
) {

    public UserDetailData(User user) {

        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProfilesList().stream()
                        .map(SimplifiedProfileDetailsData::new)
                        .toList()
        );
    }
}
