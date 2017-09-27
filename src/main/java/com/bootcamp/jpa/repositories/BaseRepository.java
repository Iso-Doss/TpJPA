package com.bootcamp.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by darextossa on 9/22/17.
 */
public class BaseRepository {

    private EntityManager em;
    private String UnitPersistence;

    public BaseRepository(String UnitPersistence) {
        this.UnitPersistence = UnitPersistence;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UnitPersistence);
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(getUnitPersistence());
        setEm(emf.createEntityManager());
        return getEm();
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the UnitPersistence
     */
    public String getUnitPersistence() {
        return UnitPersistence;
    }

    /**
     * @param UnitPersistence the UnitPersistence to set
     */
    public void setUnitPersistence(String UnitPersistence) {
        this.UnitPersistence = UnitPersistence;
    }
}
