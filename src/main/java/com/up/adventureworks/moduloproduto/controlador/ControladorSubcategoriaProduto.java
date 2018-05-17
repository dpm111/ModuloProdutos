package com.up.adventureworks.moduloproduto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.up.adventureworks.moduloproduto.modelo.entidade.SubcategoriaProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioSubcategoriaProduto;

@RestController
@RequestMapping("/SubcategoriaProduto")
public class ControladorSubcategoriaProduto {

	@Autowired
	RepositorioSubcategoriaProduto RepositorioSubcategoria;
	
	@RequestMapping("/findall")
	@ResponseBody
	public List<SubcategoriaProduto> findall(){
		return (List<SubcategoriaProduto>) RepositorioSubcategoria.findAll();
	}
	
}
