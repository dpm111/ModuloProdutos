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
import com.up.adventureworks.moduloproduto.modelo.entidade.Produto;
import com.up.adventureworks.moduloproduto.modelo.entidade.ReviewProduto;
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioReviewProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class ReviewTest {

	@Autowired
	RepositorioReviewProduto RepositorioReviewProduto;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Review*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		Produto pro = new Produto();
		pro.setProdutoId(14);
		RepositorioReviewProduto.save(new ReviewProduto(pro, "Paulo", data, "blabla@bla", 5, "blablablablablablablalbalba", data));
		
		System.out.println("\n*************FindAll Review*************");
		List<ReviewProduto> c = new ArrayList<ReviewProduto>();
		c = (List<ReviewProduto>) RepositorioReviewProduto.findAll();
		for(ReviewProduto cc : c) {
		System.out.println(cc.getProdutoId()+ "  "+ cc.getNomeAvaliador()+ "  "+ cc.getDataAvaliacao() + "  "+ cc.getAvaliacao() + "  "+ cc.getComentarios()
				+ "  "+ cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
	
}
