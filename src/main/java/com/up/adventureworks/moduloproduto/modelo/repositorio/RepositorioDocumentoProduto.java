package com.up.adventureworks.moduloproduto.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.up.adventureworks.moduloproduto.modelo.entidade.DocumentoProduto;

public interface RepositorioDocumentoProduto extends CrudRepository<DocumentoProduto, Long>{

}
