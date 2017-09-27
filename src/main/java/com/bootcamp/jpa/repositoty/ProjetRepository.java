/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.Bailleur;
import modele.tp.jpa.Beneficiaire;
import modele.tp.jpa.Fournisseur;
import modele.tp.jpa.Projet;

/**
 *
 * @author Iso-Doss
 */
public class ProjetRepository {

    public void addProjet(EntityManager em, Projet projet) {
        em.getTransaction().begin();
        em.persist(projet);
        em.getTransaction().commit();
    }

    public void removeProjet(EntityManager em, Projet projet) {
        em.getTransaction().begin();
        em.remove(projet);
        em.getTransaction().commit();
    }

    public List<Projet> findAll(EntityManager em) {

        Query query = em.createQuery("select projet from Projet projet");

        List<Projet> projets = query.getResultList();

        return projets;
    }

    public List<Projet> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("projet from Projet projet where projet.nom = :nom");
        query.setParameter("nom", id);

        List<Projet> projets = query.getResultList();

        return projets;
    }

    public List<Projet> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("projet from Projet projet where projet.nom = :nom");
        query.setParameter("nom", nom);

        List<Projet> projets = query.getResultList();

        return projets;
    }

    public List<Projet> findByObjectif(EntityManager em, String objectif) {

        Query query = em.createQuery("projet from Projet projet where projet.nom = :nom");
        query.setParameter("nom", objectif);

        List<Projet> projets = query.getResultList();

        return projets;
    }

    public List<Bailleur> getBailleursOfProjet(EntityManager em, Projet projet) {

        Query query = em.createQuery("select bailleurs from Projet projet join projet.bailleurs bailleurs where projet.id = :id");
        query.setParameter("id", projet.getId());

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

    public List<Fournisseur> getFournisseursOfProjet(EntityManager em, Projet projet) {

        Query query = em.createQuery("select fournisseurs from Projet projet join projet.fournisseurs ournisseurs where projet.id = :id");
        query.setParameter("id", projet.getId());

        List<Fournisseur> fournisseurs = query.getResultList();

        return fournisseurs;
    }

    public List<Beneficiaire> getBeneficiairesOfProjet(EntityManager em, Projet projet) {

        Query query = em.createQuery("select beneficiaires from Projet projet join projet.beneficiaires beneficiaires where projet.id = :id");
        query.setParameter("id", projet.getId());

        List<Beneficiaire> beneficiaires = query.getResultList();

        return beneficiaires;
    }

}
