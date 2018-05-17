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
import com.up.adventureworks.moduloproduto.modelo.entidade.UnidadeMedida;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioUnidadeMedida;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class UnidadeMedidaTest {

	@Autowired
	RepositorioUnidadeMedida RepositorioUnidadeMedida;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert UnidadeMedida*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		RepositorioUnidadeMedida.save(new UnidadeMedida("CM", "Centimetro", data));
		
		System.out.println("\n*************FindAll UnidadeMedida*************");
		List<UnidadeMedida> c = new ArrayList<UnidadeMedida>();
		c = (List<UnidadeMedida>) RepositorioUnidadeMedida.findAll();
		for(UnidadeMedida cc : c) {
		System.out.println(cc.getUnidadeMedidaId()+ "  "+ cc.getNome()+ "  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
}
