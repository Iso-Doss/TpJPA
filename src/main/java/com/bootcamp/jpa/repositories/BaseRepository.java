package com.bootcamp.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by darextossa on 9/22/17.
 */
public class BaseRepository {

    protected EntityManager em;
    protected String UnitPersistence;

    public BaseRepository(String UnitPersistence) {
        this.UnitPersistence = UnitPersistence;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UnitPersistence);
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UnitPersistence);
        em = emf.createEntityManager();
        return em;
    }
}
