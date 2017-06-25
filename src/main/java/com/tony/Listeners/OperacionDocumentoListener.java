package com.tony.Listeners;

import com.tony.Dao.hibernateSession;
import javax.persistence.PreUpdate;

import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.UsuarioInterno.AuditoriaUsuario;
import javax.persistence.PostPersist;
import org.hibernate.Session;

public class OperacionDocumentoListener {
    private final hibernateSession hibernate_sesion = hibernateSession.get_instancia_hibernateSession();
    @PostPersist
    public void InsertarAuditoriaDocumento(OperacionDocumento operacionDocumento) {
        System.out.println("Ingreso al postPersist");
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        try {
            AuditoriaUsuario aui = new AuditoriaUsuario(operacionDocumento);
            aui.setAccion("Registro");
            sesion.beginTransaction();
            sesion.persist(aui);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("el mensaje viene de OperacionDocumentoListener:InsertarAuditoriaDocumento " + e.getMessage());
        } finally {
            sesion.close();
        }

    }

    @PreUpdate
    public void Configuar(OperacionDocumento op) {

    }

}
