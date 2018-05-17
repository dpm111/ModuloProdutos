package br.edu.up.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.jpa.dominio.Aluno;

/**
 * Gerenciamento de dados para alunos da Universidade.
 * <p>
 * Criado por Geucimar Brilhador
 */
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
}
