package br.edu.up.jpa.dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Entidade Pessoa.
 * <p>
 * Criada por Geucimar Brilhador
 */
@Embeddable
public class Pessoa {
	
    @Column
    private String nome;

    @Column
    private String sobrenome;

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    protected Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return " nome='" + nome + '\'' + ", sobrenome='" + sobrenome + "\' ";
    }
}
