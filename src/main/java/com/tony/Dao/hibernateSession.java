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

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration configuracion = new Configuration();
            configuracion.configure();
            sessionFactory = configuracion.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  

//    public hibernateSession() {
//        Configuration configuracion = new Configuration();
//        configuracion.configure();
//        SessionFactory sessionFactory = configuracion.buildSessionFactory();
//        sesion = sessionFactory.openSession();
//        sesion.beginTransaction();
//    }

    public Session get_Sesion() {
       
        return sessionFactory.openSession();
    }


}
