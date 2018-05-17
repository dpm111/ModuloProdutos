package com.up.adventureworks.moduloproduto.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.up.adventureworks.moduloproduto.modelo.entidade.CategoriaProduto;

@Repository
public interface RepositorioCategoriaProduto extends CrudRepository<CategoriaProduto, Integer> {
	
	

}
