package models;

import entities.Pessoa;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaModel {

    EntityManager em;

    public void create(Pessoa p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");

            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Pessoa pessoa = em.find(Pessoa.class, p.getId());

            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa removida com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        em = JPAUtil.getEntityManager();

        try {
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            return pessoa;

        } catch (Exception e) {
            System.err.println("Erro ao buscar a pessoa !!!" + e.getMessage());
        }

        return null;
    }

    public List findAll() {
        em = JPAUtil.getEntityManager();
        List pessoas;

        try {
            Query query = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
            pessoas = query.getResultList();

            return pessoas;
        } catch (Exception e) {
            System.err.println("Erro ao buscar as pessoas !!!" + e.getMessage());
        }

        return null;
    }
}
