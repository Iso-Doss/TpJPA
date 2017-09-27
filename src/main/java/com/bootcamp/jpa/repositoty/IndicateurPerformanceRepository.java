/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.repositoty;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.tp.jpa.IndicateurPerformance;

/**
 *
 * @author Iso-Doss
 */
public class IndicateurPerformanceRepository {

    public void addIndicateurPerformance(EntityManager em, IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.persist(indicateurPerformance);
        em.getTransaction().commit();
    }

    public void removeIndicateurPerformance(EntityManager em, IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.remove(indicateurPerformance);
        em.getTransaction().commit();
    }

    public List<IndicateurPerformance> findAll(EntityManager em) {

        Query query = em.createQuery("select indicateurPerformance from IndicateurPerformance indicateurPerformance");

        List<IndicateurPerformance> indicateurPerformances = query.getResultList();

        return indicateurPerformances;
    }

    public List<IndicateurPerformance> findById(EntityManager em, Integer id) {

        Query query = em.createQuery("indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.nom = :nom");
        query.setParameter("nom", id);

        List<IndicateurPerformance> indicateurPerformances = query.getResultList();

        return indicateurPerformances;
    }

    public List<IndicateurPerformance> findByLibelle(EntityManager em, String libelle) {

        Query query = em.createQuery("indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.nom = :nom");
        query.setParameter("nom", libelle);

        List<IndicateurPerformance> indicateurPerformances = query.getResultList();

        return indicateurPerformances;
    }

    public List<IndicateurPerformance> findByNature(EntityManager em, String nature) {

        Query query = em.createQuery("indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.nom = :nom");
        query.setParameter("nom", nature);

        List<IndicateurPerformance> indicateurPerformances = query.getResultList();

        return indicateurPerformances;
    }

    public List<IndicateurPerformance> findByValeur(EntityManager em, String valeur) {

        Query query = em.createQuery("indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.nom = :nom");
        query.setParameter("nom", valeur);

        List<IndicateurPerformance> indicateurPerformances = query.getResultList();

        return indicateurPerformances;
    }
}
