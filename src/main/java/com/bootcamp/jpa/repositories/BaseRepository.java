package com.bootcamp.jpa.repositories;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;

/**
 * Created by darextossa on 9/22/17.
 *
 * @param <T>
 */
public abstract class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence;

    public BaseRepository(String unitPersistence) {
        this.unitPersistence = unitPersistence;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);
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
        return unitPersistence;
    }

    /**
     * @param unitPersistence
     */
    public void setUnitPersistence(String unitPersistence) {
        this.unitPersistence = unitPersistence;
    }

    /**
     * Méthode de création
     *
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    public boolean create(T obj) throws SQLException {
        em.persist(obj);
        return true;
    }

    /**
     * Méthode pour effacer
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean delete(T obj) throws SQLException {
        em.remove(obj);
        return true;
    }

    /**
     * Méthode de mise à jour
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean update(T obj) throws SQLException {
        em.merge(obj);
        return true;
    }

    /**
     * Méthode de recherche des informations
     *
     * @param propertyName
     * @param value
     * @return T
     * @throws java.sql.SQLException
     */
    public T findByProperty(String propertyName, Object value) throws SQLException {
        T result = null;
        String className = result.getClass().getSimpleName();
        String query = "select t from " + className + " t where t." + propertyName + "=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        return (T) qry.getSingleResult();
    }

    /*
      * Méthode de recherche de tous les objets
     */
    public List<T> findAll() throws SQLException {
        T result = null;
        String className = result.getClass().getSimpleName();
        String query = "select t from " + className;
        Query qry = getEm().createQuery(query);
        return (List<T>) qry.getSingleResult();
    }
}
