/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "ProgrammeFournisseur")
@Table(name = "tp_progamme_tp_fournisseur")
public class ProgrammeFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmeFournisseur")
    private List<Programme> programmes = new ArrayList<Programme>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmeFournisseur")
    private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgrammeFournisseur)) {
            return false;
        }
        ProgrammeFournisseur other = (ProgrammeFournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.ProgrammeFournisseur[ id=" + id + " ]";
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
     * @return the fournisseurs
     */
    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    /**
     * @param fournisseurs the fournisseurs to set
     */
    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

}
