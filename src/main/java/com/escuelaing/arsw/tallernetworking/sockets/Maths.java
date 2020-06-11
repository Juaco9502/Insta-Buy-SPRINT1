/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escuelaing.arsw.tallernetworking.sockets;

/**
 *
 * @author juaco
 */
public class Maths {

    private static Functions f = Functions.COSENO;

    public static double fun(double num) {
        double respuesta;
        switch (f) {
            case SENO:
                respuesta = Math.sin(num);
                break;
            case TANGENTE:
                respuesta = Math.tan(num);
                break;
            default:
                respuesta = Math.cos(num);
                break;
        }
        return respuesta;
    }

    public static Functions getF() {
        return f;
    }

    public static void setF(Functions f) {
        Maths.f = f;
    }
    
    
}
