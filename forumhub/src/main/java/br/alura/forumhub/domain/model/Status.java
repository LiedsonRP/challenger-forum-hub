package br.alura.forumhub.domain.model;

import lombok.Getter;

@Getter
public enum Status {
    OPEN ("Aberto a resposta"),
    CLOSED("Fechado");

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }
}
