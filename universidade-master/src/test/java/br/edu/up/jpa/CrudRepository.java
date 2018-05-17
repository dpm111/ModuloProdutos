package br.edu.up.jpa;

import br.edu.up.jpa.dominio.Aluno;
import br.edu.up.jpa.dominio.Pessoa;
import br.edu.up.jpa.repository.AlunoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Criação, leitura, atualização e exclusão de alunos no repository Alunos.
 * <p>
 * Criado por Geucimar Brilhador
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepository {


    @Autowired
    AlunoRepository alunoRepository;

    /**
     * Métodos Crud.
     */
    @Test
    public void exemploDeCrud() {
        boolean tempoIntegral = true;
        alunoRepository.save(new Aluno(new Pessoa("Marcos", "Aparecido"), tempoIntegral, 20));
        alunoRepository.save(new Aluno(new Pessoa("Paulo", "Silveira"), tempoIntegral, 22));
        alunoRepository.save(new Aluno(new Pessoa("Ricardo", "Amorim"), tempoIntegral, 18));
        alunoRepository.save(new Aluno(new Pessoa("Pedro", "da Silva"), !tempoIntegral, 19));

        System.out.println("\n*************Todos os alunos*************");
        alunoRepository.findAll().forEach(System.out::println);

        //alterar a idade dos alunos
        alunoRepository.findAll().forEach(aluno -> {
            aluno.setIdade(aluno.getIdade() + 1);
            alunoRepository.save(aluno);
        });

        System.out.println("\n*************Alunos com nova idade*************");
        alunoRepository.findAll().forEach(System.out::println);

//        alunoRepository.deleteAll();
//        System.out.println("\n*************Alunos excluídos*************");
//        alunoRepository.findAll().forEach(System.out::println);

    }


}
