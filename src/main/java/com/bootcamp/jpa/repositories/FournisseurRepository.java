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
public class FournisseurRepository extends BaseRepository {

    public FournisseurRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addFournisseur(Fournisseur fournisseur) {
        em.getTransaction().begin();
        em.persist(fournisseur);
        em.getTransaction().commit();
    }

    public void removeFournisseur(Fournisseur fournisseur) {
        em.getTransaction().begin();
        em.remove(fournisseur);
        em.getTransaction().commit();
    }

    public List<Fournisseur> findAll() {
        Query query = em.createQuery("select fournisseur from Fournisseur fournisseur");
        return query.getResultList();
    }

    public Fournisseur findById(Fournisseur fournisseur) {
        Query query = em.createQuery("select fournisseur from Fournisseur fournisseur where fournisseur.nom = :id");
        query.setParameter("id", fournisseur.getId());
        return (Fournisseur) query.getSingleResult();
    }

    public List<Fournisseur> findByName(Fournisseur fournisseur) {
        Query query = em.createQuery("select fournisseur from Fournisseur fournisseur where fournisseur.nom = :nom");
        query.setParameter("nom", fournisseur.getNom());
        return query.getResultList();
    }

}
