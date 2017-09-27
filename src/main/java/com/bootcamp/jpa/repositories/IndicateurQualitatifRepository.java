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
public class IndicateurQualitatifRepository extends BaseRepository {

    public IndicateurQualitatifRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addIndicateurQualitatif(IndicateurQualitatif indicateurQualitatif) {
        getEm().getTransaction().begin();
        getEm().persist(indicateurQualitatif);
        getEm().getTransaction().commit();
    }

    public void removeIndicateurQualitatif(IndicateurQualitatif indicateurQualitatif) {
        getEm().getTransaction().begin();
        getEm().remove(indicateurQualitatif);
        getEm().getTransaction().commit();
    }

    public List<IndicateurQualitatif> findAll() {
        Query query = getEm().createQuery("select indicateurQualitatif from IndicateurQualitatif indicateurQualitatif");
        return query.getResultList();
    }

    public List<IndicateurQualitatif> findById(IndicateurQualitatif indicateurQualitatif) {
        Query query = getEm().createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", indicateurQualitatif.getId());
        return query.getResultList();
    }

    public List<IndicateurQualitatif> findByNom(IndicateurQualitatif indicateurQualitatif) {
        Query query = getEm().createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.nom = :nom");
        query.setParameter("nom", indicateurQualitatif.getNom());
        return query.getResultList();
    }

    public List<IndicateurQualitatif> findByPropriete(IndicateurQualitatif indicateurQualitatif) {
        Query query = getEm().createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.propriete = :propriete");
        query.setParameter("propriete", indicateurQualitatif.getPropriete());
        return query.getResultList();
    }

    public List<IndicateurQualitatif> findByValeur(IndicateurQualitatif indicateurQualitatif) {
        Query query = getEm().createQuery("indicateurQualitatif from IndicateurQualitatif indicateurQualitatif where indicateurQualitatif.valeur = :valeur");
        query.setParameter("valeur", indicateurQualitatif.getValeur());
        return query.getResultList();
    }
}
