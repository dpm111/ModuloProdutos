package com.up.adventureworks.moduloproduto.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.up.adventureworks.moduloproduto.modelo.entidade.Produto;

public interface RepositorioProduto extends CrudRepository<Produto, Long>{

}
