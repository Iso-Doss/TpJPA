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
public class IndicateurPerformanceRepository extends BaseRepository {

    public IndicateurPerformanceRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.persist(indicateurPerformance);
        em.getTransaction().commit();
    }

    public void removeIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        em.getTransaction().begin();
        em.remove(indicateurPerformance);
        em.getTransaction().commit();
    }

    public List<IndicateurPerformance> findAll() {
        Query query = em.createQuery("select indicateurPerformance from IndicateurPerformance indicateurPerformance");
        return query.getResultList();
    }

    public IndicateurPerformance findById(IndicateurPerformance indicateurPerformance) {
        Query query = em.createQuery(" select indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.id = :id");
        query.setParameter("id", indicateurPerformance.getId());
        return (IndicateurPerformance) query.getSingleResult();
    }

    public List<IndicateurPerformance> findByNom(IndicateurPerformance indicateurPerformance) {
        Query query = em.createQuery("select indicateurPerformance from IndicateurPerformance indicateurPerformance where indicateurPerformance.nom = :nom");
        query.setParameter("nom", indicateurPerformance.getNom());
        return query.getResultList();
    }

}