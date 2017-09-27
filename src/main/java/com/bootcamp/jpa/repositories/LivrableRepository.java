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
public class LivrableRepository extends BaseRepository {

    public LivrableRepository(String UnitPersistence) {
        super(UnitPersistence);
    }

    public void addLivrable(Livrable livrable) {
        getEm().getTransaction().begin();
        getEm().persist(livrable);
        getEm().getTransaction().commit();
    }

    public void removeLivrable(Livrable livrable) {
        getEm().getTransaction().begin();
        getEm().remove(livrable);
        getEm().getTransaction().commit();
    }

    public List<Livrable> findAll() {
        Query query = getEm().createQuery("select livrable from Livrable livrable");
        return query.getResultList();
    }

    public Livrable findById(Livrable livrable) {
        Query query = getEm().createQuery("livrable from Livrable livrable where livrable.nom = :nom");
        query.setParameter("nom", livrable.getId());
        return (Livrable) query.getSingleResult();
    }

    public List<Livrable> findByName(Livrable livrable) {
        Query query = getEm().createQuery("livrable from Livrable livrable where livrable.nom = :nom");
        query.setParameter("nom", livrable.getNom());
        return query.getResultList();
    }

}
