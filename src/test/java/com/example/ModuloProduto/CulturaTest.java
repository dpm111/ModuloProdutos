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
import com.up.adventureworks.moduloproduto.modelo.entidade.Cultura;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioCultura;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class CulturaTest {

	@Autowired
	RepositorioCultura RepositorioCultura;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Culturas*************");
		String dataString = "27/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		RepositorioCultura.save(new Cultura("teste2","Movimento",data));
		
		
		System.out.println("\n*************FindAll Culturas*************");
		List<Cultura> c = new ArrayList<Cultura>();
		c = (List<Cultura>) RepositorioCultura.findAll();
		for(Cultura cc : c) {
		System.out.println(cc.getCulturaId()+ "  "+ cc.getDataModificacao() + "  "+ cc.getNome());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
}
