/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * EJERCICIO 1
 * @author juaco
 */
public class URLManager {
    
    /**
     * Url Manager, method main
     * @param args  - String []
     */
    public static void main(String[] args){
        try {
                String siteURLString = "http://ldbn.escuelaing.edu.co:80/foto.png?name=user&color=red#name";
        URL siteUrl = new URL (siteURLString);
        System.out.println("Protocolo: "+ siteUrl.getProtocol());
        System.out.println("Authority: "+ siteUrl.getAuthority());
        System.out.println("Host: "+ siteUrl.getHost());
        System.out.println("Port: "+ siteUrl.getPort());
        System.out.println("Path: "+ siteUrl.getPath());
        System.out.println("Query: "+ siteUrl.getQuery());
        System.out.println("File: "+ siteUrl.getFile());
        System.out.println("Ref: "+ siteUrl.getRef());
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
