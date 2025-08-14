package br.alura.forumhub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * Entidade que representa um perfil de usuário
 */
public class Profile {

    private Long id;
    private String name;


    private User user;
}
