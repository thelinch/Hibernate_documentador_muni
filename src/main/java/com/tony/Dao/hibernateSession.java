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

    private static SessionFactory sessionFactory;
    private static hibernateSession instancia_hibernate = null;
//    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//            // config file.
//            Configuration configuracion = new Configuration();
//            configuracion.configure();
//            sessionFactory = configuracion.buildSessionFactory();
//        } catch (Throwable ex) {
//            // Log the exception. 
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

    public static hibernateSession get_instancia_hibernateSession() {
        if (instancia_hibernate == null) {
            instancia_hibernate = new hibernateSession();
        }
        return instancia_hibernate;
    }
//    public static SessionFactory get_session_factory() {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        sessionFactory = configuration.buildSessionFactory();
//        return sessionFactory;
//    }

    private hibernateSession() {
        Configuration configuracion = new Configuration();
        configuracion.configure();
        sessionFactory = configuracion.buildSessionFactory();

    }

    public SessionFactory get_sessionFactor() {
        return sessionFactory;
    }
//    public Session get_Sesion() {
//        return sessionFactory.openSession();
//    }

}
