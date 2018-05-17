package com.up.adventureworks.moduloproduto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.up.adventureworks.moduloproduto.modelo.repositorio")
public class ModuloProdutoApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(ModuloProdutoApplication.class, args);
	}
	
	
}

