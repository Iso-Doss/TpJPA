/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.Livrable;

/**
 *
 * @author Iso-Doss
 */
public class LivrableRepository {

    public void addLivrable(EntityManager em, Livrable livrable) {
        em.getTransaction().begin();
        em.persist(livrable);
        em.getTransaction().commit();
    }

    public void removeLivrable(EntityManager em, Livrable livrable) {
        em.getTransaction().begin();
        em.remove(livrable);
        em.getTransaction().commit();
    }

    public List<Livrable> findAll(EntityManager em) {

        Query query = em.createQuery("select livrable from Livrable livrable");

        List<Livrable> livrables = query.getResultList();

        return livrables;
    }

    public List<Livrable> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("livrable from Livrable livrable where livrable.nom = :nom");
        query.setParameter("nom", id);

        List<Livrable> livrables = query.getResultList();

        return livrables;
    }
    
    public List<Livrable> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("livrable from Livrable livrable where livrable.nom = :nom");
        query.setParameter("nom", nom);

        List<Livrable> livrables = query.getResultList();

        return livrables;
    }


}
