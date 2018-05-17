package br.edu.up.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.jpa.dominio.Departamento;

/**
 * Gerenciamento de dados para os Departamento da Universidade.
 * <p>
 * Criado por Geucimar Brilhador.
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
