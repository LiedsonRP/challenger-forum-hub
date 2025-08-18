package br.alura.forumhub.domain.service;

import br.alura.forumhub.domain.dto.user.NewUserData;
import br.alura.forumhub.domain.model.User;
import br.alura.forumhub.domain.repository.UserRepository;
import br.alura.forumhub.domain.validations.ProfileValidations.ProfileNameAlreadyExists;
import br.alura.forumhub.domain.validations.UserValidations.EmailAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailAlreadyExists emailValidation;

    @Autowired
    private ProfileNameAlreadyExists profileNameValidation;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveNewUser(NewUserData newUserData) {

        emailValidation.validate(newUserData.email());
        profileNameValidation.validate(newUserData.newProfileData());

        var user = new User(newUserData);
        user.setPassword(passwordEncoder.encode(newUserData.password()));
        userRepository.save(user);

        return user;
    }
}
