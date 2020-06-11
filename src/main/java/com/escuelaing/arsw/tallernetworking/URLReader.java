/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking;

import java.util.Scanner;

/**
 * EJERCICIO 2
 * @author juaco
 */
public class URLReader {
    /**
     * URL Reader main method
     * @param args - String []
     * @throws Exception - Excepción
     */
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese URL: ");
        String url = reader.next();
        Browser.createHtml(url);
        reader.close();
    }
}
