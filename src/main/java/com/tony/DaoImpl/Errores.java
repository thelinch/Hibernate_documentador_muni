/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import org.hibernate.Session;

/**
 *
 * @author antony
 */
public class Errores {

    private static Errores error = null;

    private Errores() {
    }

    public static Errores get_intancia_error() {
        if (error == null) {
            error = new Errores();
        }
        return error;
    }

    public void Manejador_errores(Session sesion, String mensaje) {
        if (sesion.getTransaction().isActive()) {
            sesion.getTransaction().rollback();
            System.out.println("el mensaje biene de " + mensaje);
        }
    }
}
