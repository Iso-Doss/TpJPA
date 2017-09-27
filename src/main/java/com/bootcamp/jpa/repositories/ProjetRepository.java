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
public class ProjetRepository extends BaseRepository {

    public ProjetRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addProjet(Projet projet) {
        getEm().getTransaction().begin();
        getEm().persist(projet);
        getEm().getTransaction().commit();
    }

    public void removeProjet(Projet projet) {
        getEm().getTransaction().begin();
        getEm().remove(projet);
        getEm().getTransaction().commit();
    }

    public List<Projet> findAll() {
        Query query = getEm().createQuery("select projet from Projet projet");
        return query.getResultList();
    }

    public Projet findById(Projet projet) {
        Query query = getEm().createQuery("projet from Projet projet where projet.id = :id");
        query.setParameter("id", projet.getId());
        return (Projet) query.getSingleResult();
    }

    public List<Projet> findByName(Projet projet) {
        Query query = getEm().createQuery("projet from Projet projet where projet.nom = :nom");
        query.setParameter("nom", projet.getNom());
        return query.getResultList();
    }

    public List<Projet> findByObjectif(Projet projet) {
        Query query = getEm().createQuery("projet from Projet projet where projet.nom = :nom");
        query.setParameter("nom", projet.getObjectif());
        return query.getResultList();
    }

    public List<Bailleur> getBailleursOfProjet(Projet projet) {
        Query query = getEm().createQuery("select bailleurs from Projet projet join projet.bailleurs bailleurs where projet.id = :id");
        query.setParameter("id", projet.getId());
        return query.getResultList();
    }

    public List<Fournisseur> getFournisseursOfProjet(Projet projet) {
        Query query = getEm().createQuery("select fournisseurs from Projet projet join projet.fournisseurs ournisseurs where projet.id = :id");
        query.setParameter("id", projet.getId());
        return query.getResultList();
    }

    public List<Beneficiaire> getBeneficiairesOfProjet(Projet projet) {
        Query query = getEm().createQuery("select beneficiaires from Projet projet join projet.beneficiaires beneficiaires where projet.id = :id");
        query.setParameter("id", projet.getId());
        return query.getResultList();
    }

}
