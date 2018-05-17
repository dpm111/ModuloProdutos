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
import com.up.adventureworks.moduloproduto.modelo.entidade.DescricaoProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioDescricaoProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class DescricaoTest {

	@Autowired
	RepositorioDescricaoProduto RepositorioDescricaoProduto;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Descrição*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		RepositorioDescricaoProduto.save(new DescricaoProduto("Esse é muito dahora", "3242353463464", data));
		
		System.out.println("\n*************FindAll Descrição*************");
		List<DescricaoProduto> c = new ArrayList<DescricaoProduto>();
		c = (List<DescricaoProduto>) RepositorioDescricaoProduto.findAll();
		for(DescricaoProduto cc : c) {
		System.out.println(cc.getDescricaoProdutoId()+ "  "+ cc.getDescricao()+ "  "+ cc.getRowGuide() + "  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
	
}
