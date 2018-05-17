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
import com.up.adventureworks.moduloproduto.modelo.entidade.ModeloProduto;
import com.up.adventureworks.moduloproduto.modelo.entidade.Produto;
import com.up.adventureworks.moduloproduto.modelo.entidade.ProdutoIlustracaoModelo;
import com.up.adventureworks.moduloproduto.modelo.entidade.ReviewProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioProdutoIlustracaoModelo;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioReviewProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class ProdutoIlustracaoModeloTest {

	@Autowired
	RepositorioProdutoIlustracaoModelo RepositorioProdutoIlustracaoModelo;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert ProdutoIlustracaoModelo*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		Ilustracao ilu = new Ilustracao();
		ilu.setIlustracaoId(22);
		ModeloProduto mpr = new ModeloProduto();
		mpr.setModeloProdutoId(23);
		RepositorioProdutoIlustracaoModelo.save(new ProdutoIlustracaoModelo(mpr, ilu, data));
		
		System.out.println("\n*************FindAll ProdutoIlustracaoModelo*************");
		List<ProdutoIlustracaoModelo> c = new ArrayList<ProdutoIlustracaoModelo>();
		c = (List<ProdutoIlustracaoModelo>) RepositorioProdutoIlustracaoModelo.findAll();
		for(ProdutoIlustracaoModelo cc : c) {
		System.out.println(cc.getModeloProduto()+ "  "+ cc.getIlustracaoProduto()+"  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
	
}
