/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.IndicateurQualitatif;

/**
 *
 * @author Iso-Doss
 */
public class IndicateurQualitatifRepository {

    public void addIndicateurQualitatif(EntityManager em, IndicateurQualitatif indicateurQualitatif) {
        em.getTransaction().begin();
        em.persist(indicateurQualitatif);
        em.getTransaction().commit();
    }

    public void removeIndicateurQualitatif(EntityManager em, IndicateurQualitatif indicateurQualitatif) {
        em.getTransaction().begin();
        em.remove(indicateurQualitatif);
        em.getTransaction().commit();
    }

    public List<IndicateurQualitatif> findAll(EntityManager em) {

        Query query = em.createQuery("select indicateurQualitatif from IndicateurQualitatif indicateurQualitatif");

        List<IndicateurQualitatif> indicateurQualitatifs = query.getResultList();

        return indicateurQualitatifs;
    }

    public List<IndicateurQualitatif> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", id);

        List<IndicateurQualitatif> indicateurQualitatifs = query.getResultList();

        return indicateurQualitatifs;
    }

    public List<IndicateurQualitatif> findByLibelle(EntityManager em, String libelle) {

        Query query = em.createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", libelle);

        List<IndicateurQualitatif> indicateurQualitatifs = query.getResultList();

        return indicateurQualitatifs;
    }

    public List<IndicateurQualitatif> findByNature(EntityManager em, String nature) {

        Query query = em.createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", nature);

        List<IndicateurQualitatif> indicateurQualitatifs = query.getResultList();

        return indicateurQualitatifs;
    }

    public List<IndicateurQualitatif> findByValeur(EntityManager em, String valeur) {

        Query query = em.createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", valeur);

        List<IndicateurQualitatif> indicateurQualitatifs = query.getResultList();

        return indicateurQualitatifs;
    }
}
