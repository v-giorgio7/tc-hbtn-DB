package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) throws ParseException {
        testarAlunoModel();
        System.out.println("\n------------\n");
        //testarCursoModel();
    }

    private static List<Aluno> testarAlunoModel() throws ParseException {
        AlunoModel alunoModel = new AlunoModel();

        Endereco enderecoUm = new Endereco();
        Endereco enderecoDois = new Endereco();
        enderecoUm.setLogradouro("Avenida");
        enderecoUm.setEndereco("Avenida Niemeyer");
        enderecoUm.setNumero("30");
        enderecoUm.setBairro("Ibirapuera");
        enderecoUm.setCidade("Sao Paulo");
        enderecoUm.setEstado("SP");
        enderecoUm.setCep(11222300);
        enderecoDois.setLogradouro("Rua");
        enderecoDois.setEndereco("Rua Marechal");
        enderecoDois.setNumero("302");
        enderecoDois.setBairro("Antero");
        enderecoDois.setCidade("Rio de Janeiro");
        enderecoDois.setEstado("RJ");
        enderecoDois.setCep(22333400);

        Telefone telefoneUm = new Telefone();
        Telefone telefoneDois = new Telefone();
        telefoneUm.setDdd("19");
        telefoneUm.setNumero("999998888");
        telefoneDois.setDdd("21");
        telefoneDois.setNumero("977775555");

        Aluno alunoUm = new Aluno();
        Aluno alunoDois = new Aluno();
        alunoUm.setNomeCompleto("Andre Silveira");
        alunoUm.setMatricula("1122334455");
        alunoUm.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/1990"));
        alunoUm.setEmail("andre@techcamps.com");
        alunoUm.setEnderecos(Arrays.asList(enderecoUm));
        alunoUm.setTelefones(Arrays.asList(telefoneUm));
        alunoDois.setNomeCompleto("Mariana Albuquerque");
        alunoDois.setMatricula("6677889900");
        alunoDois.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/1992"));
        alunoDois.setEmail("mariana@techcamps.com");
        alunoDois.setEnderecos(Arrays.asList(enderecoDois));
        alunoDois.setTelefones(Arrays.asList(telefoneDois));

        //1) Criando um aluno
        alunoModel.create(alunoUm);
        alunoModel.create(alunoDois);

        //2) Buscando todos os alunos na base de dados
        List<Aluno> alunosEncontrados = alunoModel.findAll();
        System.out.println("Qtde de alunos encontrados : " + alunosEncontrados.size() + "\n");
        alunosEncontrados.forEach(aluno -> System.out.println(aluno.getId() + " - " + aluno.getNomeCompleto()));

        System.out.println("----------------------");

        //3) Buscando um aluno por id
        System.out.println(alunoModel.findById(alunoUm.getId()));
        System.out.println(alunoModel.findById(alunoDois.getId()));

        System.out.println("----------------------");

        //4) Atualizar um aluno
        alunoUm.setNomeCompleto("Andre Albuquerque");
        alunoModel.update(alunoUm);

        System.out.println("----------------------");

        //5) Deletar um aluno
        alunoModel.delete(alunoUm);
        System.out.println(alunoModel.findAll());

        return alunosEncontrados;
    }

    private static void testarCursoModel() throws ParseException {
        CursoModel cursoModel = new CursoModel();

        MaterialCurso materialUm = new MaterialCurso();
        MaterialCurso materialDois = new MaterialCurso();
        materialUm.setUrl("https://www.youtube.com/watch?v=ODXvvEzXlQY");
        materialDois.setUrl("https://thedevconf.com/arquivos/tdc/2012/JPA_TDC2012.pdf");

        Professor professorUm = new Professor();
        Professor professorDois = new Professor();
        professorUm.setNomeCompleto("Alberto Ferreira");
        professorUm.setMatricula("1111111");
        professorUm.setEmail("alberto@techcamps.com");
        professorDois.setNomeCompleto("Vinicius Gusmao");
        professorDois.setMatricula("2222222");
        professorDois.setEmail("vinicius@techcamps.com");

        Endereco enderecoUm = new Endereco();
        enderecoUm.setLogradouro("Avenida");
        enderecoUm.setEndereco("Avenida Niemeyer");
        enderecoUm.setNumero("30");
        enderecoUm.setBairro("Ibirapuera");
        enderecoUm.setCidade("Sao Paulo");
        enderecoUm.setEstado("SP");
        enderecoUm.setCep(11222300);

        Telefone telefoneUm = new Telefone();
        telefoneUm.setDdd("19");
        telefoneUm.setNumero("999998888");

        Aluno alunoUm = new Aluno();
        alunoUm.setNomeCompleto("Andre Silveira");
        alunoUm.setMatricula("1122334455");
        alunoUm.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/1990"));
        alunoUm.setEmail("andre@techcamps.com");
        alunoUm.setEnderecos(Arrays.asList(enderecoUm));
        alunoUm.setTelefones(Arrays.asList(telefoneUm));

        Curso cursoUm = new Curso();
        Curso cursoDois = new Curso();
        cursoUm.setNome("Java Bootcamp");
        cursoUm.setSigla("JAVA");
        cursoUm.setMaterial(materialUm);
        cursoUm.setProfessor(professorUm);
        cursoUm.setAlunos(Arrays.asList(alunoUm));
        cursoDois.setNome("Java Bootcamp 2");
        cursoDois.setSigla("JAVA 2");
        cursoDois.setMaterial(materialDois);
        cursoDois.setProfessor(professorDois);
        cursoDois.setAlunos(Arrays.asList(alunoUm));


        //1) Criando um curso
        cursoModel.create(cursoUm);
        cursoModel.create(cursoDois);

        //2) Buscando todos os cursos na base de dados
        List<Curso> cursosEncontrados = cursoModel.findAll();
        System.out.println("Qtde de cursos encontrados : " + cursosEncontrados.size() + "\n");
        cursosEncontrados.forEach(curso -> System.out.println(curso.getId() + " - " + curso.getNome()));

        System.out.println("----------------------");

        //3) Buscando um curso por id
        System.out.println(cursoModel.findById(cursoUm.getId()));
        System.out.println(cursoModel.findById(cursoDois.getId()));

        System.out.println("----------------------");

        //4) Atualizar um curso
        cursoUm.setSigla("JAVA BOOT");
        cursoModel.update(cursoUm);

        System.out.println("----------------------");

        //5) Deletar um curso
        cursoModel.delete(cursoUm);
        System.out.println(cursoModel.findAll());

    }
}
