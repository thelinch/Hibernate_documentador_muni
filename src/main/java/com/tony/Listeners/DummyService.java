/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Listeners;

import com.tony.Dao.hibernateSession;
import com.tony.DaoImpl.Errores;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.UsuarioInterno.AuditoriaUsuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author antony
 */
public class DummyService {

//    private hibernateSession hibernate_sesion = hibernateSession.get_instancia_hibernateSession();
    private Errores error = Errores.get_intancia_error();

    public void PrePersist_add_auditoria_usuario_by_operacion_documento(OperacionDocumento operacion_documento) {
        AuditoriaUsuario auditoria_usuario = new AuditoriaUsuario();
        auditoria_usuario.setAccion("registro");
        operacion_documento.AddAuditoriaUsuario(auditoria_usuario);
    }

    public void Pre_Insert_add_auditoria_documento_by_Operacion_estadoDocumentos(Operacion_EstadosDocumentos operacion_estado_documento, Session sesion) {
        AuditoriaDocumento auiditoria_documento = new AuditoriaDocumento();
        try {
//            List<Estado_documentos> lista_estados = sesion.createCriteria(Documento.class).createAlias("operacionEstados", "op")
//                    .setProjection(Projections.property("op.estados"))
//                    .add(Restrictions.idEq(operacion_estado_documento.getDocumento().getId_documento())).list();
//            auiditoria_documento.setEstadoActual(operacion_estado_documento.getEstados().getEstado().toString());
//
//            lista_estados.forEach(System.out::println);
//            sesion.getTransaction().commit();

//            if (!lista_estados.isEmpty() && lista_estados.size() >= 1) {
//                auiditoria_documento.setEstadoAnterior(lista_estados.get(lista_estados.size() - 1).getEstado().toString());
//            } else {
//                auiditoria_documento.setEstadoAnterior(null);
//            }
//            operacion_estado_documento.AddAuditoriaDocumento(auiditoria_documento);
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "el mensaje viene de DummyService :Pre_inset_add_auditoria_documento " + e.getMessage());
        }

    }

}
