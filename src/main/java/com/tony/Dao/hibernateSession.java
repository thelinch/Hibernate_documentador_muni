/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class hibernateSession {

    private static SessionFactory session_factory;

    public static synchronized void build_session_factory() {
        if (session_factory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            session_factory = configuration.buildSessionFactory();
        }
    }

    public static void open_session_and_bind_to_thread() {
        Session sesion = session_factory.openSession();
        ThreadLocalSessionContext.bind(sesion);
    }

    public static SessionFactory get_session_factory() {
        if (session_factory == null) {
            build_session_factory();
        }
        return session_factory;
    }
    public static void close_session_and_unbind_Thread()
    {
        Session session=ThreadLocalSessionContext.unbind(session_factory);
        if(session==null){
            session.close();
        }
    }
    public static void close_session_factory(){
        if((session_factory!=null) && session_factory.isClosed()==false){
            session_factory.close();
        }
    }
//    private Session sesion;
//    private static hibernateSession instancia_sesion = null;
//
//    public static hibernateSession get_instancia_hibernate_session() {
//        if (instancia_sesion == null) {
//            instancia_sesion = new hibernateSession();
//        }
//        return instancia_sesion;
//    }
//
//    private hibernateSession() {
//        Configuration configuracion = new Configuration();
//        configuracion.configure();
//        SessionFactory sessionFactory = configuracion.buildSessionFactory();
//        sesion = sessionFactory.openSession();
//    }
//
//    public Session AbrirSesion() {
//        return sesion;
//    }
//
//    protected void CerrarSesion() {
//        sesion.getTransaction().commit();
//
//    }

}
