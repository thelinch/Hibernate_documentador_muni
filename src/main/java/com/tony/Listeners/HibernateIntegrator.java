/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Listeners;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 *
 * @author antony
 */
public class HibernateIntegrator implements Integrator {

    @Override
    public void integrate(Metadata mtdt, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        final EventListenerRegistry eventListenerRegistry = sfsr.getService(EventListenerRegistry.class);

        Operacion_Documento_Event_adapter pea = new Operacion_Documento_Event_adapter();
        
        pea.setService(new DummyService());

        eventListenerRegistry.setListeners(EventType.PRE_INSERT, pea);
        eventListenerRegistry.setListeners(EventType.PRE_UPDATE, pea);
        eventListenerRegistry.setListeners(EventType.POST_INSERT, pea);
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
