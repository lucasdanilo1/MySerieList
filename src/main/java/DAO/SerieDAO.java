package DAO;

import SerieBuilder.Serie;

import javax.persistence.EntityManager;

public class SerieDAO {

    private EntityManager em;

    public SerieDAO(EntityManager em){
        this.em = em;
    }
    public void cadastrar(Serie serie){
        this.em.persist(serie);
    }



}
