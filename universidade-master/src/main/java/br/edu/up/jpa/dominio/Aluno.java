package br.edu.up.jpa.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade JPA que representa o aluno da Universidade.
 * <p>
 * Criado por Geucimar Brilhador
 */
@Entity
@Table(name = "aluno")
public class Aluno {
	
    @Id
    @GeneratedValue
    private Integer alunoId;

    @Column
    private boolean tempoIntegral;

    @Column
    private Integer idade;

    @Embedded
    private Pessoa pessoa;

    @OneToMany
    private List<Curso> cursos = new ArrayList<>();

    public Aluno(Pessoa pessoa, boolean tempoIntegral, Integer idade) {
        this.pessoa = pessoa;
        this.tempoIntegral = tempoIntegral;
        this.idade = idade;
        cursos = new ArrayList<>();
    }

    protected Aluno() {
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isTempoIntegral() {
        return tempoIntegral;
    }

    public Integer getIdade() {
        return idade;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        return "Aluno{" + "alunoId=" + alunoId + ", " + pessoa + ", tempoIntegral=" + tempoIntegral +
                ", idade=" + idade + "}\n";
    }
}
