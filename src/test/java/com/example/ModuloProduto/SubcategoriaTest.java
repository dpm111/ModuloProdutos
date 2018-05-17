package com.example.ModuloProduto;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.up.adventureworks.moduloproduto.ModuloProdutoApplication;
import com.up.adventureworks.moduloproduto.modelo.entidade.CategoriaProduto;
import com.up.adventureworks.moduloproduto.modelo.entidade.SubcategoriaProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioCategoriaProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioSubcategoriaProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class SubcategoriaTest {

	@Autowired
	RepositorioSubcategoriaProduto RepositorioSubcategoriaProduto;
	@Autowired
	RepositorioCategoriaProduto RepositorioCategoriaProduto;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Culturas*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		CategoriaProduto cat = new CategoriaProduto();
		cat.setCategoriaProdutoId(3);
		RepositorioSubcategoriaProduto.save(new SubcategoriaProduto(cat, "celular","1234567890",data));
		
		System.out.println("\n*************FindAll Culturas*************");
		List<SubcategoriaProduto> c = new ArrayList<SubcategoriaProduto>();
		c = (List<SubcategoriaProduto>) RepositorioSubcategoriaProduto.findAll();
		for(SubcategoriaProduto cc : c) {
		System.out.println(cc.getSubcategoriaProdutoId()+ "  "+ cc.getNome()+ "  "+ cc.getRowGuide() + "  "+ cc.getDataModificacao() + "  "+ cc.getCategoriaProduto().getCategoriaProdutoId());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
	
}
