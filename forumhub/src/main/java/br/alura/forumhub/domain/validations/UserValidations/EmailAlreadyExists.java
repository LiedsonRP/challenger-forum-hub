package br.alura.forumhub.domain.validations.UserValidations;

import br.alura.forumhub.domain.repository.UserRepository;
import br.alura.forumhub.infra.Exceptions.EmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailAlreadyExists {

    @Autowired
    private UserRepository userRepository;

    public void validate(String email) {
        var emailAlreadyExists = userRepository.existsByEmail(email);

        if (emailAlreadyExists) {
            throw new EmailAlreadyExistsException("O Email inserido já existe, insira um novo ou faça login com sua conta!");
        }
    }
}
