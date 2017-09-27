/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositories;

import java.util.List;
import javax.persistence.Query;
import com.bootcamp.jpa.entities.*;

/**
 *
 * @author Iso-Doss
 */
public class PersonneRepository extends BaseRepository {

    public PersonneRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addPersonne(Personne personne) {
        em.getTransaction().begin();
        em.persist(personne);
        em.getTransaction().commit();
    }

    public void removePersonne(Personne personne) {
        em.getTransaction().begin();
        em.remove(personne);
        em.getTransaction().commit();
    }

    public List<Personne> findAll() {
        Query query = em.createQuery("select personne from Personne personne");
        return query.getResultList();
    }

    public Personne findById(Personne personne) {
        Query query = em.createQuery("select personne from Personne personne where personne.id = :id");
        query.setParameter("id", personne.getId());
        return (Personne) query.getSingleResult();
    }

    public List<Personne> findByName(Personne personne) {
        Query query = em.createQuery("select personne from Personne personne where personne.nom = :nom");
        query.setParameter("nom", personne.getNom());
        return query.getResultList();
    }

}
