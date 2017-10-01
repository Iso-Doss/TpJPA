/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Bailleur")
@Table(name = "tp_bailleur")
@DiscriminatorValue("TP_BAILLEUR")
@NamedQueries({
    @NamedQuery(
            name = "Bailleur.findAll",
            query = "select bailleur from Bailleur bailleur")
    ,
    @NamedQuery(
            name = "Bailleur.findByName",
            query = "select bailleur from Bailleur bailleur where bailleur.nom = :nom")
    , 
    @NamedQuery(
            name = "Bailleur.countAll",
            query = "select count(bailleur) from Bailleur bailleur"),})
public class Bailleur extends Personne {
    
    @NotNull(message = "Le champ type de bailleur ne peut etre null.")
    @Column(name = "typeDeBailleur", length = 45, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TypeDeBailleur typeDeBailleur;

    @ManyToMany(mappedBy = "bailleurs")
    private List<Programme> programmes = new ArrayList<Programme>();

    @ManyToMany(mappedBy = "bailleurs")
    private List<Projet> projets = new ArrayList<Projet>();

    /**
     * @return the typeDeBailleur
     */
    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    /**
     * @param typeDeBailleur the typeDeBailleur to set
     */
    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
    }

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
