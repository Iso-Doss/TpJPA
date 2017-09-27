/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.Fournisseur;

/**
 *
 * @author Iso-Doss
 */
public class FournisseurRepository {

    public void addFournisseur(EntityManager em, Fournisseur fournisseur) {
        em.getTransaction().begin();
        em.persist(fournisseur);
        em.getTransaction().commit();
    }

    public void removeFournisseur(EntityManager em, Fournisseur fournisseur) {
        em.getTransaction().begin();
        em.remove(fournisseur);
        em.getTransaction().commit();
    }

    public List<Fournisseur> findAll(EntityManager em) {

        Query query = em.createQuery("select fournisseur from Fournisseur fournisseur");

        List<Fournisseur> fournisseurs = query.getResultList();

        return fournisseurs;
    }

    public List<Fournisseur> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("fournisseur from Fournisseur fournisseur where fournisseur.nom = :nom");
        query.setParameter("nom", id);

        List<Fournisseur> fournisseurs = query.getResultList();

        return fournisseurs;
    }

    public List<Fournisseur> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("fournisseur from Fournisseur fournisseur where fournisseur.nom = :nom");
        query.setParameter("nom", nom);

        List<Fournisseur> fournisseurs = query.getResultList();

        return fournisseurs;
    }

}
