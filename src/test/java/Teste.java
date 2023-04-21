import SerieBuilder.Serie;
import SerieBuilder.Status;
import SerieList.SerieList;
import DAO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws Exception {

        //CRIAÇÃO DE SÉRIES
        Serie PeakyBlinders = new Serie("PeakyBlinders", "Sujiro kimimame", 12, 2000);
        Serie Spartacus = new Serie("Spartacus", "Danilo Diniz", 10, 2001);
        Serie Monster = new Serie("Monster", "Gabriel Bembem", 24, 1999);
        Serie StrangerThings = new Serie("StrangerThings", "Lucas Danilo", 12, 2020);
        Serie GossipGirl = new Serie("GossipGirl", "Gustavo Milho", 24, 2007);

        //CIRAÇÃO DE UMA REFERENCIA (ESSA REFERENCIA É A QUE FICARÁ NA MINHA LISTA PESSOAL) A UMA SERIE EXISTENTE.
        SerieList slStrangerThings = new SerieList(StrangerThings, Status.COMPLETED);
        SerieList slSpartacus = new SerieList(Spartacus, Status.COMPLETED);
        SerieList slMonster = new SerieList(Monster, Status.COMPLETED);
        SerieList slPeakyBlinders = new SerieList(PeakyBlinders, Status.COMPLETED);
        SerieList slGossipGirl = new SerieList(GossipGirl, Status.WATCHING);

        //SETANDO NOTA A SERIE NA MINHA LISTA
        slMonster.setScore(2);
        //SETANDO PROGRESSO DE EPISODIOS PARA A SERIE NA MINHA LISTA
        slMonster.setProgress(5);
        //SETANDO STATUS COMO "DROPPED" (DESISTI DE ASSISTIR) PARA A SERIE NA MINHA LISTA
        slMonster.setStatus(Status.DROPPED);

        //CADASTRO DA SERIE NO BANCO DE DADOS
        cadastrarSerie(Monster, slMonster);


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myserielist");
        EntityManager em = factory.createEntityManager();

        SerieListDAO serieListDAO = new SerieListDAO(em);
        SerieDAO serieDAO = new SerieDAO(em);

    }

    private static void cadastrarSerie(Serie serie, SerieList serielist) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myserielist");
        EntityManager em = factory.createEntityManager();

        SerieListDAO serieListDAO = new SerieListDAO(em);
        SerieDAO serieDAO = new SerieDAO(em);

        em.getTransaction().begin();
        serieDAO.cadastrar(serie);
        serieListDAO.cadastrar(serielist);
        em.getTransaction().commit();
        em.close();
    }

}
