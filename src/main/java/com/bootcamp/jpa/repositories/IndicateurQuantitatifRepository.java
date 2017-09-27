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
public class IndicateurQuantitatifRepository extends BaseRepository {

    public IndicateurQuantitatifRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addIndicateurQuantitatif(IndicateurQuantitatif indicateurQuantitatif) {
        getEm().getTransaction().begin();
        getEm().persist(indicateurQuantitatif);
        getEm().getTransaction().commit();
    }

    public void removeIndicateurQuantitatif(IndicateurQuantitatif indicateurQuantitatif) {
        getEm().getTransaction().begin();
        getEm().remove(indicateurQuantitatif);
        getEm().getTransaction().commit();
    }

    public List<IndicateurQuantitatif> findAll() {
        Query query = getEm().createQuery("select indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif");
        return query.getResultList();
    }

    public IndicateurQuantitatif findById(IndicateurQuantitatif indicateurQuantitatif) {
        Query query = getEm().createQuery("select indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.id = :id");
        query.setParameter("id", indicateurQuantitatif.getId());
        return (IndicateurQuantitatif) query.getSingleResult();
    }

    public List<IndicateurQuantitatif> findByNom(IndicateurQuantitatif indicateurQuantitatif) {
        Query query = getEm().createQuery("select indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.nom = :nom");
        query.setParameter("nom", indicateurQuantitatif.getNom());
        return query.getResultList();
    }

    public List<IndicateurQuantitatif> findByPropriete(IndicateurQuantitatif indicateurQuantitatif) {
        Query query = getEm().createQuery("select indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.propriete = :propriete");
        query.setParameter("propriete", indicateurQuantitatif.getPropriete());
        return query.getResultList();
    }

    public List<IndicateurQuantitatif> findByValeur(IndicateurQuantitatif indicateurQuantitatif) {
        Query query = getEm().createQuery("indicateurQuantitatif from IndicateurQuantitatif indicateurQuantitatif where indicateurQuantitatif.valeur = :valeur");
        query.setParameter("valeur", indicateurQuantitatif.getValeur());
        return query.getResultList();
    }
}
