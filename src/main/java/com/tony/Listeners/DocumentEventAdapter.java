/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Listeners;

import org.hibernate.event.spi.PostInsertEvent;

/**
 *
 * @author antony
 */
public class DocumentEventAdapter extends HibernateEventAdapter {

    private DummyService service = new DummyService();

    @Override
    public void onPostInsert(PostInsertEvent pie) {
        this.service.process("fedw", pie.getEntity());
           }

    public void setService(DummyService service) {
        this.service = service;
    }

}
