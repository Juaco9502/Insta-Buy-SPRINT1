/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking.sockets;

import java.net.*;
import java.io.*;

/**
 * Clase servidor que regresa el mismo mensaje que lee
 * @author juaco
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(
                    "Mensaje: " + inputLine
            );
            inputLine = inputLine.toLowerCase();
            outputLine = "Invalid request";
            if (inputLine.contains("fun:")) {
                outputLine = "Nueva funcion establecida!";
                if (inputLine.contains("sin")) {
                    Maths.setF(Functions.SENO);
                } else if (inputLine.contains("tan")) {
                    Maths.setF(Functions.TANGENTE);
                } else if (inputLine.contains("cos")) {
                    Maths.setF(Functions.COSENO);
                } else {
                    outputLine = "Respuesta: funcion invalida.";
                }
            }else if (inputLine.contains("bye")){
                break;
            } else {
                try {
                    outputLine = "Respuesta: " + Maths.getF().name() + "( " + inputLine + " ) " + Maths.fun(Double.parseDouble(inputLine));
                } catch (NumberFormatException e) {
                    outputLine="Ingrese un numero valido: 1, 1.5, -0.5, etc.";
                }
            }
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
