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
import com.up.adventureworks.moduloproduto.modelo.entidade.Ilustracao;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioIlustracao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class IlustracaoTest {

	@Autowired
	RepositorioIlustracao Repositorioilustracao;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Ilustracao*************");
		String dataString = "27/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		Repositorioilustracao.save(new Ilustracao("Diagrama Test",data));
		
		
		System.out.println("\n*************FindAll Ilustracao*************");
		List<Ilustracao> c = new ArrayList<Ilustracao>();
		c = (List<Ilustracao>) Repositorioilustracao.findAll();
		for(Ilustracao cc : c) {
		System.out.println(cc.getIlustracaoId()+ "  "+ cc.getDiagrama() + "  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
	
}
