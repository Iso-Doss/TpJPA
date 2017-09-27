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
public class BailleurRepository extends BaseRepository {

    public BailleurRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addBailleur(Bailleur bailleur) {
        getEm().getTransaction().begin();
        getEm().persist(bailleur);
        getEm().getTransaction().commit();
    }

    public void removeBailleur(Bailleur bailleur) {
        getEm().getTransaction().begin();
        getEm().remove(bailleur);
        getEm().getTransaction().commit();
    }

    public List<Bailleur> findAll() {
        Query query = getEm().createQuery("select bailleur from Bailleur bailleur");
        return query.getResultList();
    }

    public Bailleur findById(Bailleur bailleur) {
        Query query = getEm().createQuery("select bailleur from Bailleur bailleur where bailleur.id = :id");
        query.setParameter("id", bailleur.getId());
        return (Bailleur) query.getSingleResult();
    }

    public List<Bailleur> findByName(Bailleur bailleur) {
        Query query = getEm().createQuery("select bailleur from Bailleur bailleur where bailleur.nom = :nom");
        query.setParameter("nom", bailleur.getNom());
        return query.getResultList();
    }

    public List<Bailleur> findByTypeDeBailleur(Bailleur bailleur) {
        Query query = getEm().createQuery("select bailleur from Bailleur bailleur where bailleur.typeDeBailleur = :type");
        query.setParameter("type", bailleur.getTypeDeBailleur());
        return query.getResultList();
    }

}
