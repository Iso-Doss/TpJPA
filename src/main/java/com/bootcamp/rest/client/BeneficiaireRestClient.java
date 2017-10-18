/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author soul
 */
public class BeneficiaireRestClient {

    private String SERVICE_URL = "http://e210c022.ngrok.io/rest/beneficiaire";
    private DefaultHttpClient httpClient;
    private String FIND_ALL_URI = "/list";

    public BeneficiaireRestClient() {
        httpClient = new DefaultHttpClient();
    }

    public void findAll() {
        String uri = SERVICE_URL + FIND_ALL_URI;
        HttpGet getRequest = new HttpGet(
                uri);
        getRequest.addHeader("accept", "application/json");
        try {
            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            parseResponse(response); //appel de la réponse
        } catch (IOException ex) {
            Logger.getLogger(BeneficiaireRestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parseResponse(HttpResponse response) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
    }
}
