/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking.sockets;

/**
 * La clase search contiene dos metodos que permiten buscar y obtener palabras
 * dentro de una cadena.
 *
 * @author juaco
 */
public class Search {

    /**
     * La siguiente funcion permite saber si una palabra (buscar) esta contenida
     * en una cadena (frase), si la palabra esta contenida en la cadena retorna
     * true, en caso contrario retorna false.
     *
     * @param buscar - String
     * @param frase - String
     * @return boolean respuesta.
     */
    public static boolean existWord(String buscar, String frase) {
        boolean respuesta = false;
        String[] palabras = frase.split("\\W+");
        for (String palabra : palabras) {
            if (buscar.contains(palabra)) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    /**
     * La siguiente funcion obtiene la segunda palabra de una cadena. Se usa
     * para obtener el recurso que se hace en una peticion GET http.
     *
     * @param frase - String
     * @return string - Recurso
     */
    public static String searchResource(String frase) {
        String[] palabras = frase.split("\\W+");
        return palabras[1];
    }
}
