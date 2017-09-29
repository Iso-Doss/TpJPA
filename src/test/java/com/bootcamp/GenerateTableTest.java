package com.bootcamp;

import com.bootcamp.jpa.repositories.*;
import javax.persistence.*;
import org.testng.annotations.Test;
import com.bootcamp.jpa.entities.*;
import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by darextossa on 9/22/17.
 */
public class GenerateTableTest {

    @Test
    public void generateTablesMysql() {
        Persistence.generateSchema("tpJpa", new Properties());
    }

    @Test
    public void generateTablesDerby() {
        Persistence.generateSchema("com.bootcamp_TpJPA", new Properties());
    }

    @Test
    public void loadPersonnes() {
        List<Personne> personnes = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Personne personne = new Personne();
            personne.setNom(nom[i]);
            personnes.add(personne);
        }

        PersonneRepository pr = new PersonneRepository("com.bootcamp_TpJPA");
        for (Object element : personnes) {
            pr.addPersonne((Personne) element);
        }

    }

    /*
    @Test
    public void loadBailleurs() {
        List<Bailleur> bailleurs = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Bailleur bailleur = new Bailleur();
            bailleur.setNom(nom[i]);
            bailleur.setTypeDeBailleur(TypeDeBailleur.privé);
            bailleurs.add(bailleur);
        }

        BailleurRepository br = new BailleurRepository("com.bootcamp_TpJPA");
        for (Object element : bailleurs) {
            br.addBailleur((Bailleur) element);
        }

    }

    @Test
    public void loadBeneficiaires() {
        List<Beneficiaire> beneficiaires = new LinkedList();

        String nom[] = {"Iso", "Doss", "Ros"};
        for (int i = 0; i < nom.length; i++) {
            Beneficiaire beneficiaire = new Beneficiaire();
            beneficiaire.setNom(nom[i]);
            beneficiaires.add(beneficiaire);
        }

        BeneficiaireRepository br = new BeneficiaireRepository("tpJpa");
        for (Object element : beneficiaires) {
            br.addBeneficiaire((Beneficiaire) element);
        }

    }
     */
}
