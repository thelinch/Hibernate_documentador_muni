/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Listeners;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

/**
 *
 * @author antony
 */
public class HibernateEventAdapter implements PreInsertEventListener, PostInsertEventListener, PreUpdateEventListener, PostUpdateEventListener {

    @Override
    public boolean onPreInsert(PreInsertEvent pie) {
        return false;
    }

    @Override
    public void onPostInsert(PostInsertEvent pie) {
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister ep) {
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent pue) {
        return false;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent pue) {
    }

}
