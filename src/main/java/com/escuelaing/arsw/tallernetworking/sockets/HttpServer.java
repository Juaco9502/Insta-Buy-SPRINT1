package com.escuelaing.arsw.tallernetworking.sockets;

import java.net.*;
import java.io.*;

/**
 * La clase HttpServer se comporta como un servidor web, el cual recibe
 * peticiones por medio del protocolo http y responde con recursos html y png
 * usando este mismo protocolo.
 *
 * @author juaco
 */
public class HttpServer {

    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(getPort());
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    ));
            String inputLine;
            //Read the client's request.
            inputLine = in.readLine();
            //The request header is searched to find out if the requested resource is png or html.
            if (inputLine != null && inputLine.contains("GET")) {
                String[] encabezado = inputLine.split(" ");
                String recurso = encabezado[1];
                if (recurso.contains("png")) {
                    byte[] image = Reader.imageReader(Search.searchResource(inputLine));
                    DataOutputStream binaryOut;
                    binaryOut = new DataOutputStream(clientSocket.getOutputStream());
                    binaryOut.writeBytes("HTTP/1.1 200 OK \r\n");
                    binaryOut.writeBytes("Content-Type: image/png\r\n");
                    binaryOut.writeBytes("Content-Length: " + image.length);
                    binaryOut.writeBytes("\r\n\r\n");
                    binaryOut.write(image);
                    binaryOut.close();
                } else {
                    try {
                            out.println(Reader.htmlReader(Search.searchResource(inputLine)));
                    } catch (IOException e) {
                        out.println("HTTP/1.1 404 NOT FOUND\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                + "404 NOT FOUND \n"
                                + e.getMessage());
                    }
                }
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
    }

    /**
     * La siguiente funcion retorna un numero entero, que correspondera al
     * puerto por el cual se establecera la comunicacion entre el cliente y el
     * servidor.
     *
     * @return int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e.on localhost)
    }

}
