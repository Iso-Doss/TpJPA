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
public class ProgrammeRepository extends BaseRepository {

    public ProgrammeRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addProgramme(Programme programme) {
        getEm().getTransaction().begin();
        getEm().persist(programme);
        getEm().getTransaction().commit();
    }

    public void removeProgramme(Programme programme) {
        getEm().getTransaction().begin();
        getEm().remove(programme);
        getEm().getTransaction().commit();
    }

    public List<Programme> findAll() {
        Query query = getEm().createQuery("select programme from Programme programme");
        return query.getResultList();
    }

    public Programme findById(Programme programme) {
        Query query = getEm().createQuery("programme from Programme programme where programme.id = :id");
        query.setParameter("id", programme.getId());
        return (Programme) query.getSingleResult();
    }

    public List<Programme> findByName(Programme programme) {
        Query query = getEm().createQuery("programme from Programme programme where programme.nom = :nom");
        query.setParameter("nom", programme.getNom());
        return query.getResultList();
    }

    public List<Programme> findByObjectif(Programme programme) {
        Query query = getEm().createQuery("programme from Programme programme where programme.objectif = :objectif");
        query.setParameter("objectif", programme.getObjectif());
        return query.getResultList();
    }

    public List<Bailleur> getBailleursOfProgramme(Programme programme) {
        Query query = getEm().createQuery("select bailleurs from Programme programme join programme.bailleurs bailleurs where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

    public List<Fournisseur> getFournisseursOfProgramme(Programme programme) {
        Query query = getEm().createQuery("select fournisseurs from Programme programme join programme.fournisseurs ournisseurs where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

    public List<Beneficiaire> getBeneficiairesOfProgramme(Programme programme) {
        Query query = getEm().createQuery("select beneficiaires from Programme programme join programme.beneficiaires beneficiaires where programme.id = :id");
        query.setParameter("id", programme.getId());
        return query.getResultList();
    }

}
