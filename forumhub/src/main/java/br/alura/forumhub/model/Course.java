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
 * Entidade que representa um curso do sistema
 */
public class Course {

    private Long id;
    private String name;
    private Category category;
}
