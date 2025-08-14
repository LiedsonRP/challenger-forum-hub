package br.alura.forumhub.model;

import lombok.Getter;

/**
 * Determina as categorias disponíveis no sistema
 */
@Getter
public enum Category {

    WEBDEVELOPMENT("Desenvolvimento Web"),
    DATABASE("Banco de Dados"),
    CIBERCECURITY("Cibersigurança"),
    UXDESIGN("UX Design"),
    TIINFRAESTRUCTURE("Infraestrutura em TI");

    private String br_name;

    Category(String br_name) {
        this.br_name = br_name;
    }

}
