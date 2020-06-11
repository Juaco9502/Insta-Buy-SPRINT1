/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * EJERCICIO 2
 * @author juaco
 */
public class Browser {

    /**
     * Request a URL from the user, read the data and store it in a result.html file
     * @param url - String
     * @throws MalformedURLException - Lanzado para indicar que se ha producido una URL con formato incorrecto.
     * @throws IOException - Señala que se ha producido una excepción de E / S de algún tipo.
     */
    public static void createHtml(String url) throws MalformedURLException, IOException {
        File archivo = new File("C:\\Users\\juaco\\Downloads\\Repositorio\\resultado.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        URL newUrl = new URL(url);
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(newUrl.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                bw.write(inputLine);
            }
            bw.close();
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
