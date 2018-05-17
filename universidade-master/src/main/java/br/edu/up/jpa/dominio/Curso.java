package br.edu.up.jpa.dominio;

import javax.persistence.*;

/**
 * Entidade JPA para os Cursos oferecidos na Universidade.
 * <p>
 * Criado por Geucimar Brilhador.
 */
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn
    private Departamento departamento;

    public Curso(String name, Departamento departamento) {
        this.nome = name;
        this.departamento = departamento;
    }

    protected Curso() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id + ", nome='" + nome + '\'' + ", departamento=" + departamento.getNome() + '}';
    }
}
