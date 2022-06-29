package models;

import entities.Produto;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutoModel {

    EntityManager em;

    public void create(Produto p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");

            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Produto produto = em.find(Produto.class, p.getId());

            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
            System.out.println("Produto removido com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        em = JPAUtil.getEntityManager();

        try {
            Produto produto = em.find(Produto.class, p.getId());
            return produto;

        } catch (Exception e) {
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        }

        return null;
    }

    public List findAll() {
        em = JPAUtil.getEntityManager();
        List produtos;

        try {
            Query query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            produtos = query.getResultList();

            return produtos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar os produtos !!!" + e.getMessage());
        }

        return null;
    }

}