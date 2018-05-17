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
import com.up.adventureworks.moduloproduto.modelo.entidade.ModeloProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioModeloProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class ModeloProdutoTest {

	@Autowired
	RepositorioModeloProduto RepositorioModeloProduto;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert ModeloProduto*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		RepositorioModeloProduto.save(new ModeloProduto("descricao test", "catal cat test", "instru test","46246w45754745724", data));
		
		System.out.println("\n*************FindAll ModeloProduto*************");
		List<ModeloProduto> c = new ArrayList<ModeloProduto>();
		c = (List<ModeloProduto>) RepositorioModeloProduto.findAll();
		for(ModeloProduto cc : c) {
		System.out.println(cc.getModeloProdutoId()+ "  "+ cc.getDescricao()+ "  "+ cc.getDescricaoCatalogo() + "  "+ cc.getInstrucoes() + "  "+ cc.getRowGuide()
				+ "  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
}
