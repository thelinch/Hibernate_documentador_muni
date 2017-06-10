/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateSession {

    private Session sesion;
    private static hibernateSession instancia_sesion = null;

    public static hibernateSession get_instancia_hibernate_session() {
        if (instancia_sesion == null) {
            instancia_sesion = new hibernateSession();
        }
        return instancia_sesion;
    }

    private hibernateSession() {
        Configuration configuracion = new Configuration();
        configuracion.configure();
        SessionFactory sessionFactory = configuracion.buildSessionFactory();
        sesion = sessionFactory.openSession();
    }

    public Session AbrirSesion() {
        sesion.beginTransaction();
        return sesion;
    }

    protected void CerrarSesion() {
        sesion.getTransaction().commit();

    }

}
