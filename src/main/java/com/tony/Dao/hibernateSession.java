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

    public hibernateSession() {
        Configuration configuracion=new Configuration();
        configuracion.configure();
        SessionFactory sessionFactory=configuracion.buildSessionFactory();
        this.sesion=sessionFactory.openSession();
        this.sesion.beginTransaction();
    }

    public Session getSesion() {
        return sesion;
    }
    
    
}
