package br.alura.forumhub.domain.validations.ProfileValidations;

import br.alura.forumhub.domain.repository.ProfileRepository;
import br.alura.forumhub.infra.Exceptions.ProfileAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.alura.forumhub.domain.dto.profile.NewProfileDTO;

@Component
public class ProfileNameAlreadyExists {

    @Autowired
    private ProfileRepository profileRepository;

    public void validate(NewProfileDTO data) {

        var profileAlreadyExists = profileRepository.existsByName(data.name());

        if (profileAlreadyExists) {
            throw new ProfileAlreadyExistsException("O nome de perfil inserido já está cadastrado, crie um novo ou faça login com sua conta!");
        }
    }
}
