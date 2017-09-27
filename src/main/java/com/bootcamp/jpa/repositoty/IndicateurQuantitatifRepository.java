/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.IndicateurQuantitatif;

/**
 *
 * @author Iso-Doss
 */
public class IndicateurQuantitatifRepository {

    public void addIndicateurQuantitatif(EntityManager em, IndicateurQuantitatif indicateurQuantitatif) {
        em.getTransaction().begin();
        em.persist(indicateurQuantitatif);
        em.getTransaction().commit();
    }

    public void removeIndicateurQuantitatif(EntityManager em, IndicateurQuantitatif indicateurQuantitatif) {
        em.getTransaction().begin();
        em.remove(indicateurQuantitatif);
        em.getTransaction().commit();
    }

    public List<IndicateurQuantitatif> findAll(EntityManager em) {

        Query query = em.createQuery("select indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif");

        List<IndicateurQuantitatif> indicateurQuantitatifs = query.getResultList();

        return indicateurQuantitatifs;
    }

    public List<IndicateurQuantitatif> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.nom = :nom");
        query.setParameter("nom", id);

        List<IndicateurQuantitatif> indicateurQuantitatifs = query.getResultList();

        return indicateurQuantitatifs;
    }

    public List<IndicateurQuantitatif> findByLibelle(EntityManager em, String libelle) {

        Query query = em.createQuery("indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.nom = :nom");
        query.setParameter("nom", libelle);

        List<IndicateurQuantitatif> indicateurQuantitatifs = query.getResultList();

        return indicateurQuantitatifs;
    }

    public List<IndicateurQuantitatif> findByNature(EntityManager em, String nature) {

        Query query = em.createQuery("indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.nom = :nom");
        query.setParameter("nom", nature);

        List<IndicateurQuantitatif> indicateurQuantitatifs = query.getResultList();

        return indicateurQuantitatifs;
    }

    public List<IndicateurQuantitatif> findByValeur(EntityManager em, Integer valeur) {

        Query query = em.createQuery("indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.nom = :nom");
        query.setParameter("nom", valeur);

        List<IndicateurQuantitatif> indicateurQuantitatifs = query.getResultList();

        return indicateurQuantitatifs;
    }
}
