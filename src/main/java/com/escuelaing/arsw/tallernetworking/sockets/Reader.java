/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking.sockets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase Reader contiene dos metodos estaticos que permiten la lectura de
 * archivos html y png.
 *
 * @author juaco
 */
public class Reader {

    /**
     * Leer un archivo html dada la direccion (ruta) donde este se encuentra, y
     * pasarla a una cadena.
     *
     * @param ruta - String
     * @return String html con el contenido de la pagina html.
     * @throws FileNotFoundException - Señala que ha fallado un intento de abrir el archivo indicado por un nombre de ruta especificado.
     * @throws IOException - Señala que se ha producido una excepción de E / S de algún tipo.
     */
    public static String htmlReader(String ruta) throws FileNotFoundException, IOException {
        String html = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
        FileReader fr = new FileReader("./resources/" + ruta + ".html");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            html = html + line;
            line = br.readLine();
        }
        br.close();
        return html;
    }

    /**
     * Leer una imagen de tipo png, dada la direccion (ruta) donde esta se
     * encuentra, y pasarla a un arreglo de bytes.
     *
     * @param ruta - String
     * @return byte[] bytesPage, arreglo de bytes de la imagen.
     * @throws IOException - Señala que se ha producido una excepción de E / S de algún tipo.
     */
    public static byte[] imageReader(String ruta) throws IOException {
        byte[] bytesPage = new byte[]{};
        File image = new File("resources/" + ruta + ".png");
        FileInputStream inputImage = new FileInputStream(image.getPath());
        bytesPage = new byte[(int) image.length()];
        inputImage.read(bytesPage);
        return bytesPage;
    }
}
