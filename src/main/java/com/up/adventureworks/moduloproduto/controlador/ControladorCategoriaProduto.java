package com.up.adventureworks.moduloproduto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.up.adventureworks.moduloproduto.modelo.entidade.CategoriaProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioCategoriaProduto;

@RestController
@RequestMapping("/CategoriaProduto")
public class ControladorCategoriaProduto {

	@Autowired
	RepositorioCategoriaProduto RepositorioCategoria;
	
	@RequestMapping("/findall")
	@ResponseBody
	public List<CategoriaProduto> findall(){
		return (List<CategoriaProduto>) RepositorioCategoria.findAll();
	}
	
}
