/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Beneficiaire")
@Table(name = "tp_beneficiaire")
@DiscriminatorValue("TP_BENEFICIAIRE")
@NamedQueries({
    @NamedQuery(
            name = "Beneficiaire.findAll",
            query = "select beneficiaire from Beneficiaire beneficiaire")
    ,
    @NamedQuery(
            name = "Beneficiaire.findByName",
            query = "select beneficiaire from Beneficiaire beneficiaire where beneficiaire.nom = :nom")
    , 
    @NamedQuery(
            name = "Beneficiaire.countAll",
            query = "select count(beneficiaire) from Beneficiaire beneficiaire"),})
public class Beneficiaire extends Personne {

    @ManyToMany(mappedBy = "beneficiaires")
    private List<Programme> programmes = new ArrayList<Programme>();

    @ManyToMany(mappedBy = "beneficiaires")
    private List<Projet> projets = new ArrayList<Projet>();

    /**
     * @return the programmes
     */
    public List<Programme> getProgrammes() {
        return programmes;
    }

    /**
     * @param programmes the programmes to set
     */
    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    /**
     * @return the projets
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * @param projets the projets to set
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

}
