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
public class BeneficiaireRepository extends BaseRepository {

    public BeneficiaireRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addBeneficiaire(Beneficiaire beneficiaire) {
        em.getTransaction().begin();
        em.persist(beneficiaire);
        em.getTransaction().commit();
    }

    public void removeBeneficiaire(Beneficiaire beneficiaire) {
        em.getTransaction().begin();
        em.remove(beneficiaire);
        em.getTransaction().commit();
    }

    public List<Beneficiaire> findAll() {
        Query query = em.createQuery("select beneficiaire from Beneficiaire beneficiaire");
        return query.getResultList();
    }

    public Beneficiaire findById(Beneficiaire beneficiaire) {
        Query query = em.createQuery("select beneficiaire from Beneficiaire beneficiaire where beneficiaire.id = :id");
        query.setParameter("id", beneficiaire.getId());
        return (Beneficiaire) query.getSingleResult();
    }

    public List<Beneficiaire> findByName(Beneficiaire beneficiaire) {
        Query query = em.createQuery("select beneficiaire from Beneficiaire beneficiaire where beneficiaire.nom = :nom");
        query.setParameter("nom", beneficiaire.getNom());
        return query.getResultList();
    }

}
