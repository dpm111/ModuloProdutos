package br.edu.up.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.up.jpa.dominio.Departamento;
import br.edu.up.jpa.repository.DepartamentoRepository;


/**
 * Métodos JPA do DepartamentoRepository
 * <p>
 * Criado por Geucimar Brilhador
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExemploJpaRepository {
    @Autowired
    private DepartamentoRepository departamentoRepository;
    /**
     * Métodos JPA Repository.
     */
    @Test
    public void rodarMetodosJpa() {

        departamentoRepository.save(new Departamento("Ciências Humanas"));
        departamentoRepository.flush();
        departamentoRepository.saveAndFlush(new Departamento("Ciências Exatas"));
        departamentoRepository.save(new Departamento("Ciências Sociais"));

        System.out.println("\n*************3 departamentos*************");
        departamentoRepository.findAll().forEach(System.out::println);

        departamentoRepository.deleteInBatch(departamentoRepository.findAll().subList(0,1));

        System.out.println("\n*************1 departamento*************");
        departamentoRepository.findAll().forEach(System.out::println);
        departamentoRepository.deleteAllInBatch();
        System.out.println("\n*************Nenhum departamento*************");
        departamentoRepository.findAll().forEach(System.out::println);

    }
    
    @Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
}
