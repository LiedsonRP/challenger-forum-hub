package br.alura.forumhub.infra.Exceptions;

/**
 * Especifica uma exceção para quando um determinado perfil de usuário já estiver cadastrado no sistema
 */
public class ProfileAlreadyExistsException extends RuntimeException {

    public ProfileAlreadyExistsException(String msg) {
        super(msg);
    }
}
