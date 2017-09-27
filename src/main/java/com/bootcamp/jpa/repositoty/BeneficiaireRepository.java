/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.Beneficiaire;

/**
 *
 * @author Iso-Doss
 */
public class BeneficiaireRepository {

    public void addBeneficiaire(EntityManager em, Beneficiaire beneficiaire) {
        em.getTransaction().begin();
        em.persist(beneficiaire);
        em.getTransaction().commit();
    }

    public void removeBeneficiaire(EntityManager em, Beneficiaire beneficiaire) {
        em.getTransaction().begin();
        em.remove(beneficiaire);
        em.getTransaction().commit();
    }

    public List<Beneficiaire> findAll(EntityManager em) {

        Query query = em.createQuery("select beneficiaire from Beneficiaire beneficiaire");

        List<Beneficiaire> beneficiaires = query.getResultList();

        return beneficiaires;
    }

    public List<Beneficiaire> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("beneficiaire from Beneficiaire beneficiaire where beneficiaire.nom = :nom");
        query.setParameter("nom", id);

        List<Beneficiaire> beneficiaires = query.getResultList();

        return beneficiaires;
    }

    public List<Beneficiaire> findByName(EntityManager em, String nom) {

        Query query = em.createQuery("beneficiaire from Beneficiaire beneficiaire where beneficiaire.nom = :nom");
        query.setParameter("nom", nom);

        List<Beneficiaire> beneficiaires = query.getResultList();

        return beneficiaires;
    }

}
