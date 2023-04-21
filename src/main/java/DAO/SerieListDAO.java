package DAO;

import SerieBuilder.Status;
import SerieList.SerieList;

import javax.persistence.EntityManager;
import java.util.List;

public class SerieListDAO{

    private EntityManager em;

    public SerieListDAO(){
    }

    public SerieListDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(SerieList serie){
        this.em.persist(serie);
    }

    public List<SerieList> all(){
            String jpql = "select s from SerieList s";
            return em.createQuery(jpql, SerieList.class).getResultList();
        }

    public List<SerieList> completed(){
        String jpql = "select s from SerieList s where s.status = :parametro";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.COMPLETED).getResultList();
    }

    public List<SerieList> completedByScoreDesc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score desc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.COMPLETED).getResultList();
    }

    public List<SerieList> completedByScoreAsc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score asc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.COMPLETED).getResultList();
    }

    public List<SerieList> watching(){
        String jpql = "select s from SerieList s where s.status = :parametro";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.WATCHING).getResultList();
    }

    public List<SerieList> watchingByScoreAsc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score asc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.WATCHING).getResultList();
    }

    public List<SerieList> watchingByScoreDesc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score desc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.WATCHING).getResultList();
    }

    public List<SerieList> dropped(){
        String jpql = "select s from SerieList s where s.status = :parametro";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.DROPPED).getResultList();
    }

    public List<SerieList> droppedByScoreAsc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score asc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.DROPPED).getResultList();
    }

    public List<SerieList> droppedByScoreDesc(){
        String jpql = "select s from SerieList s where s.status = :parametro order by s.score desc";
        return em.createQuery(jpql, SerieList.class).setParameter("parametro", Status.DROPPED).getResultList();
    }

    public List<SerieList> byScoreDesc(){
        String jpql = "select s from SerieList s order by s.score desc";
        return em.createQuery(jpql, SerieList.class).getResultList();
    }

    public List<SerieList> byScoreAsc() {
        String jpql = "select s from SerieList s order by s.score asc";
        return em.createQuery(jpql, SerieList.class).getResultList();
    }

    public List<SerieList> byProgressAsc() {
        String jpql = "select s from SerieList s order by s.progress asc";
        return em.createQuery(jpql, SerieList.class).getResultList();
    }

    public List<SerieList> byProgressDesc() {
        String jpql = "select s from SerieList s order by s.progress desc";
        return em.createQuery(jpql, SerieList.class).getResultList();
    }





}
