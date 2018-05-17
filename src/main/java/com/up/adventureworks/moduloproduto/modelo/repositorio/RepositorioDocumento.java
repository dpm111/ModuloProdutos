package com.up.adventureworks.moduloproduto.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.up.adventureworks.moduloproduto.modelo.entidade.Documento;

public interface RepositorioDocumento extends CrudRepository<Documento, Long>{

}
