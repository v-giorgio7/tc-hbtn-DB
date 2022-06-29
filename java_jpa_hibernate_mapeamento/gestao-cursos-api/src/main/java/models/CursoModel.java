package models;

import entities.Curso;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CursoModel {

    EntityManager em;

    public void create(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        em = JPAUtil.getEntityManager();

        try {
            Curso curso = em.find(Curso.class, id);
            return curso;

        } catch (Exception e) {
            System.err.println("Erro ao buscar curso por id !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return null;
    }

    public List<Curso> findAll() {
        em = JPAUtil.getEntityManager();
        List cursos;

        try {
            Query query = em.createQuery("SELECT c FROM Curso c", Curso.class);
            cursos = query.getResultList();

            return cursos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar cursos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return null;
    }

    public void update(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        em = JPAUtil.getEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso cursoEncontrado = em.find(Curso.class, curso.getId());
            em.remove(cursoEncontrado);
            em.getTransaction().commit();
            System.out.println("Curso removido com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }
}
