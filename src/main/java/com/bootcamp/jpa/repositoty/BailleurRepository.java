/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.*;

/**
 *
 * @author Iso-Doss
 */
public class BailleurRepository {

    public void addBailleur(EntityManager em, Bailleur bailleur) {
        em.getTransaction().begin();
        em.persist(bailleur);
        em.getTransaction().commit();
    }

    public void removeBailleur(EntityManager em, Bailleur bailleur) {
        em.getTransaction().begin();
        em.remove(bailleur);
        em.getTransaction().commit();
    }

    public List<Bailleur> findAll(EntityManager em) {

        Query query = em.createQuery("select bailleur from Bailleur bailleur");

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

    public List<Bailleur> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("bailleur from Bailleur bailleur where bailleur.nom = :nom");
        query.setParameter("nom", id);

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

    public List<Bailleur> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("bailleur from Bailleur bailleur where bailleur.nom = :nom");
        query.setParameter("nom", nom);

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

    public List<Bailleur> findByTypeDeBailleur(EntityManager em, TypeDeBailleur typeDeBailleur) {

        Query query = em.createQuery("bailleur from Bailleur bailleur where bailleur.typeDeBailleur = :type");
        query.setParameter("type", typeDeBailleur);

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

}
