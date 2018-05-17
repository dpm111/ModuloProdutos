package br.edu.up.jpa.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade JPA para um Departamento de estudo da Universidade.
 * <p>
 * Criado por Geucimar Brilhador
 */
@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Curso> cursos = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    protected Departamento() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nome='" + nome + '\'' + ", cursos=" + cursos + '}';
    }
}
