package models;

import entities.Aluno;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlunoModel {

    EntityManager em;

    public void create(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        em = JPAUtil.getEntityManager();

        try {
            Aluno aluno = em.find(Aluno.class, id);
            return aluno;

        } catch (Exception e) {
            System.err.println("Erro ao buscar aluno por id !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return null;
    }

    public List<Aluno> findAll() {
        em = JPAUtil.getEntityManager();
        List alunos;

        try {
            Query query = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
            alunos = query.getResultList();

            return alunos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar alunos !!!" + e.getMessage());
        } finally{
            em.close();
            System.out.println("Finalizando a transação");
        }

        return null;
    }

    public void update(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Aluno alunoEncontrado = em.find(Aluno.class, aluno.getId());
            em.remove(alunoEncontrado);
            em.getTransaction().commit();
            System.out.println("Aluno removido com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }
}
