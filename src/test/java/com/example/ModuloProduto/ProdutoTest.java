package com.example.ModuloProduto;

import java.math.BigDecimal;
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
import com.up.adventureworks.moduloproduto.modelo.repositorio.RepositorioProduto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ModuloProdutoApplication.class)
public class ProdutoTest {
	
	@Autowired
	RepositorioProduto RepositorioProduto;
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("\n*************Insert Produto*************");
		String dataString = "28/09/1993";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(fmt.parse(dataString).getTime());
		BigDecimal bd = new BigDecimal("50.60");
		RepositorioProduto.save(new Produto("Bike", "3242353463464",(byte) 0,(byte) 0,(short) 10,(short) 3, bd, bd
				,15, data, data, data,"235346464", data));
		
		System.out.println("\n*************FindAll Produto*************");
		List<Produto> c = new ArrayList<Produto>();
		c = (List<Produto>) RepositorioProduto.findAll();
		for(Produto cc : c) {
		System.out.println(cc.getProdutoId()+ "  "+
				cc.getNome() + "  "+
				cc.getNumeroProduto() + "  "+
				cc.getMarcar() + "  "+
				cc.getMarcarFinalizado() + "  "+
				cc.getCor() + "  "+
				cc.getNivelSeguroStock() + "  "+
				cc.getPontoReabastecimento() + "  "+
				cc.getPrecoPadrao() + "  "+
				cc.getPrecoVenda() + "  "+
				cc.getTamanho() + "  "+
				cc.getCodigoUnidadeMedidaTamanho() + "  "+
				cc.getCodigoUnidadeMedidaPeso() + "  "+
				cc.getPeso() + "  "+
				cc.getDiasParaProduzir() + "  "+
				cc.getLinhaProducao() + "  "+
				cc.getClasse() + "  "+
				cc.getEstilo() + "  "+
				cc.getSubcategoriaProduto() + "  "+
				cc.getModeloProduto() + "  "+
				cc.getDataInicioVenda() + "  "+
				cc.getDataFimVenda() + "  "+
				cc.getDataDiscontinuacao() + "  "+
				cc.getRowGuide() + "  "+
				cc.getDataModificacao());
		}
		
	}
	@Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }

}
