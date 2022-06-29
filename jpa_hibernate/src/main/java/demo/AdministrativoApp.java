package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {

        // Testes para a entidade Produto:
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();

        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
            System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando um produto por id
        System.out.println(produtoModel.findById(p1));

        //4) Atualizar um produto
        Produto produtoAtualizado = produtoModel.findById(p1);
        p1.setNome("Videogame");
        p1.setPreco(3000.0);
        p1.setQuantidade(500);
        produtoModel.update(p1);

        System.out.println(produtoModel.findById(p1));

        //5) Deletar um produto
        produtoModel.delete(p1);
        System.out.println(produtoModel.findAll());

        System.out.println('\n');
        System.out.println("-------------------");
        System.out.println('\n');

        // Testes para a entidade Pessoa:
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pes1 = new Pessoa();

        pes1.setNome("Andre");
        pes1.setEmail("andre@techcamps.com");
        pes1.setIdade(23);
        pes1.setCpf("11122233344");
        pes1.setDataDeNascimento(LocalDate.of(1980, 1, 14));

        // 1) Criando uma pessoa
        pessoaModel.create(pes1);

        //2) Buscando todos as pessoas na base de dados
        List<Produto> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + pessoas.size());

        //3) Buscando uma pessoa por id
        System.out.println(pessoaModel.findById(pes1));

        //4) Atualizar uma pessoa
        Pessoa pessoaAtualizada = pessoaModel.findById(pes1);
        pes1.setNome("Andre Valdo");
        pessoaModel.update(pes1);

        System.out.println(pessoaModel.findById(pes1));

        //5) Deletar uma pessoa
        pessoaModel.delete(pes1);
        System.out.println(pessoaModel.findAll());
    }
}
