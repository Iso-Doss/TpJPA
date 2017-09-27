/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.*;

/**
 *
 * @author Iso-Doss
 */
public class ProgrammeRepository {

    public void addProgramme(EntityManager em, Programme programme) {
        em.getTransaction().begin();
        em.persist(programme);
        em.getTransaction().commit();
    }

    public void removeProgramme(EntityManager em, Programme programme) {
        em.getTransaction().begin();
        em.remove(programme);
        em.getTransaction().commit();
    }

    public List<Programme> findAll(EntityManager em) {

        Query query = em.createQuery("select programme from Programme programme");

        List<Programme> programmes = query.getResultList();

        return programmes;
    }

    public List<Programme> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("programme from Programme programme where programme.nom = :nom");
        query.setParameter("nom", id);

        List<Programme> programmes = query.getResultList();

        return programmes;
    }

    public List<Programme> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("programme from Programme programme where programme.nom = :nom");
        query.setParameter("nom", nom);

        List<Programme> programmes = query.getResultList();

        return programmes;
    }
    
    public List<Programme> findByObjectif(EntityManager em, String objectif) {

        Query query = em.createQuery("programme from Programme programme where programme.nom = :nom");
        query.setParameter("nom", objectif);

        List<Programme> programmes = query.getResultList();

        return programmes;
    }

    public List<Bailleur> getBailleursOfProgramme(EntityManager em, Programme programme) {

        Query query = em.createQuery("select bailleurs from Programme programme join programme.bailleurs bailleurs where programme.id = :id");
        query.setParameter("id", programme.getId());

        List<Bailleur> bailleurs = query.getResultList();

        return bailleurs;
    }

    public List<Fournisseur> getFournisseursOfProgramme(EntityManager em, Programme programme) {

        Query query = em.createQuery("select fournisseurs from Programme programme join programme.fournisseurs ournisseurs where programme.id = :id");
        query.setParameter("id", programme.getId());

        List<Fournisseur> fournisseurs = query.getResultList();

        return fournisseurs;
    }

    public List<Beneficiaire> getBeneficiairesOfProgramme(EntityManager em, Programme programme) {

        Query query = em.createQuery("select beneficiaires from Programme programme join programme.beneficiaires beneficiaires where programme.id = :id");
        query.setParameter("id", programme.getId());

        List<Beneficiaire> beneficiaires = query.getResultList();

        return beneficiaires;
    }

}
