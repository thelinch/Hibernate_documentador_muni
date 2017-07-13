package com.tony.Listeners;

import org.hibernate.event.spi.PreInsertEvent;

public class Operacion_Documento_Event_adapter extends HibernateEventAdapter {

    private DummyService service = new DummyService();

    @Override
    public boolean onPreInsert(PreInsertEvent pie) {
        service.process("lol", pie.getEntity());
        return false;
    }

    public void setService(DummyService service) {
        this.service = service;
    }

}
