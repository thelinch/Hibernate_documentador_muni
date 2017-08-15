package com.tony.Listeners;

import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PreInsertEvent;

public class Operacion_Documento_Event_adapter extends HibernateEventAdapter {

    private DummyService service = new DummyService();

    @Override
    public boolean onPreInsert(PreInsertEvent pie) {
//        if (pie.getEntity() instanceof OperacionDocumento) {
//            OperacionDocumento operacion_documento = (OperacionDocumento) pie.getEntity();
//            this.service.PrePersist_add_auditoria_usuario_by_operacion_documento(operacion_documento, "Registro");
//        }
        return false;
    }

    @Override
    public void onPostInsert(PostInsertEvent pie) {
        if (pie.getEntity() instanceof Operacion_EstadosDocumentos) {
            Operacion_EstadosDocumentos operacion_Estado_documento = (Operacion_EstadosDocumentos) pie.getEntity();
            this.service.Pre_Insert_add_auditoria_documento_by_Operacion_estadoDocumentos(operacion_Estado_documento, pie.getSession());
        }
    }

    public void setService(DummyService service) {
        this.service = service;
    }

}
