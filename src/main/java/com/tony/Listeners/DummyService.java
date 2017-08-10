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
import org.hibernate.query.Query;

/**
 *
 * @author antony
 */
public class DummyService {

//    private hibernateSession hibernate_sesion = hibernateSession.get_instancia_hibernateSession();
    private Errores error = Errores.get_intancia_error();

    public void PrePersist_add_auditoria_usuario_by_operacion_documento(OperacionDocumento operacion_documento, String accion) {
        AuditoriaUsuario auditoria_usuario = new AuditoriaUsuario();
        auditoria_usuario.setAccion(accion);
        operacion_documento.AddAuditoriaUsuario(auditoria_usuario);
    }

    private void last_usuario_by_documento(Session sesion, int id_documento, int id_operacion) {
        Query createQuery = sesion.createQuery("select d.id_OperacionDocumento into id_operacion_documentos from operacion_documento d join usuario_interno u on d.id_usuario=u.id_persona\n"
                + "join documento doc on d.id_documento=doc.id_documento\n"
                + "where  doc.id_documento=:documento_id and d.id_OperacionDocumento<=:id_operacion_entrada  order by d.id_OperacionDocumento desc limit 1").setParameter("documento_id", id_documento).setParameter("id_operacion_entrada", id_operacion);
        System.out.println(createQuery.uniqueResult().toString());;
    }

    public void Pre_Insert_add_auditoria_documento_by_Operacion_estadoDocumentos(Operacion_EstadosDocumentos operacion_estado_documento, Session sesion) {
        AuditoriaDocumento auiditoria_documento = new AuditoriaDocumento();
        try {
            System.out.println("la sesion esta abierta?" + sesion.isOpen());
            sesion.clear();
            sesion.detach(operacion_estado_documento);
            List<Estado_documentos> lista_estados = this.get_estados_documento(operacion_estado_documento.getDocumento().getId_documento(), sesion);
            auiditoria_documento.setEstadoActual(operacion_estado_documento.getEstados().getEstado().toString());
            if (!lista_estados.isEmpty() && lista_estados.size() >= 2) {
                auiditoria_documento.setEstadoAnterior(lista_estados.get(lista_estados.size() - 2).getEstado().toString());
            } else {
                auiditoria_documento.setEstadoAnterior(null);
            }
            lista_estados.forEach((estados) -> {
                System.out.println(" el estado viene de DummyService " + estados.getEstado() + " " + estados.getId_estadoDocumento());
            });
            operacion_estado_documento.AddAuditoriaDocumento(auiditoria_documento);

            sesion.merge(operacion_estado_documento);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "el mensaje viene de DummyService :Pre_inset_add_auditoria_documento " + e.getMessage());
        }

    }

    private List<Estado_documentos> get_estados_documento(int id_documento, Session sesion) {
        List<Estado_documentos> lista_estados = sesion.createCriteria(Documento.class).createAlias("operacionEstados", "op")
                .setProjection(Projections.property("op.estados"))
                .add(Restrictions.idEq(id_documento)).list();
        return lista_estados;
    }

}
