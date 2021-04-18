package com.example.rest.models;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Observable;


/**
 *
 * This class implement The IBibliothequeDaoRepositoryJPA
 */
public class UserRepository extends Observable implements IUserrepository {

    @Override
    public void save(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
        System.out.println("saved user ");

    }

    @Override
    public List<Utilisateur> findAll() {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select s from Utilisateur s");
        entityManager.getTransaction().commit();
        setChanged();
        notifyObservers();

        return q.getResultList();
    }

    @Override
    public void update(int id) {

    }


    @Override
    public void  delete(int id) {
        entityManager.getTransaction().begin();
        Utilisateur utilisateur =entityManager.find(Utilisateur.class ,id );
        entityManager.remove( utilisateur);
        entityManager.getTransaction().commit();
    }

    @Override
    public Utilisateur find(int uuid) {
        entityManager.getTransaction().begin();
        Utilisateur utilisateur =entityManager.find(Utilisateur.class ,uuid );
        entityManager.getTransaction().commit();
        return utilisateur;
    }


    @Override
    public void init() throws NoSuchAlgorithmException, InvalidKeySpecException {
        entityManager.getTransaction().begin();
        Utilisateur aut1 =  new Utilisateur() ;
        aut1.setFirstname("charles");
        aut1.setLastname("biancheri");
        aut1.setPassword("Djingue1994@");
        entityManager.persist(aut1);
        Utilisateur aut2 =  new Utilisateur() ;
        aut2.setFirstname("Pape Mor ");
        aut2.setLastname("CISSE");
        aut2.setLogin("pcisse200");
        aut2.setPassword("Djingue1994522");
        entityManager.persist(aut2);;

        entityManager.getTransaction().commit();

    }

    public UserRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
        // fullTextSession =  Search.getFullTextEntityManager(entityManager);

    }

    public static UserRepository getInstance() {
        if (serverInstance == null) {
            serverInstance = new UserRepository();
        }
        return serverInstance;
    }
    private static UserRepository serverInstance;
    public static EntityManager entityManager;

}

