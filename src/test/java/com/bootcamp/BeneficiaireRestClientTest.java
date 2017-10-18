package com.bootcamp;

import com.bootcamp.rest.client.BeneficiaireRestClient;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Iso-Doss
 */
public class BeneficiaireRestClientTest {

    @Test
    private void getBeneficiaires() {
        BeneficiaireRestClient beneficiairerestclient = new BeneficiaireRestClient();
        beneficiairerestclient.findAll();
    }
}
