/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_Externo;
import com.tony.Dao.hibernateSession;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UsuarioExternoImpl implements IUsuario_Externo {

    private final hibernateSession hibernatesesion = hibernateSession.get_instancia_hibernateSession();
    private final Errores error = Errores.get_intancia_error();

    public UsuarioExternoImpl() {

    }
//Probado y validado

    @Override
    public Estado_documentos get_last_state_find_by_document(int id_documento) {

        Session sesionhi = this.hibernatesesion.get_sessionFactor().openSession();
        Estado_documentos estado = null;
//        List<Estado_documentos> lista = new ArrayList<>();
        try {
            sesionhi.beginTransaction();
            Estado_documentos estadoalterna = (Estado_documentos) sesionhi.createCriteria(Operacion_EstadosDocumentos.class).createAlias("documento", "documentoBuscar")
                    .add(Restrictions.eq("documentoBuscar.id_documento", id_documento)).setProjection(Projections.max("estados")).uniqueResult();
//                    .list();
//            lista.forEach(System.out::println);
//            estado = lista.stream().max(Comparator.comparingInt(Estado_documentos::getId_estadoDocumento)).get();
            sesionhi.getTransaction().commit();
            estado = new Estado_documentos();
            estado.setEstado(estadoalterna.getEstado());
            estado.setId_estadoDocumento(estadoalterna.getId_estadoDocumento());
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioExyerno:get_last_state_find_by_document" + e.getMessage());
        } finally {
            sesionhi.close();
        }

        return estado;
    }
//Probado y validado

    @Override
    public List<Documento> get_documentos_find_by_user_externo(int user_id) {
        List<Documento> listaDocumentos_user = null;
        Session sesion = this.hibernatesesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            UsuarioExterno usuario_externo = sesion.find(UsuarioExterno.class, user_id);
            usuario_externo.getDocumentos().size();
            listaDocumentos_user = usuario_externo.getDocumentos();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Error en UsuarioExternoImpl : get_documentos_find_by_externo " + e.getMessage());
        } finally {
            sesion.close();
        }
        return listaDocumentos_user;
    }

    @Override
    public List<AuditoriaDocumento> get_auditoria_find_by_id_documento(int Id_documento) {
        List<AuditoriaDocumento> auditoria_docuemento = new ArrayList<>();
        Session sesion = this.hibernatesesion.get_sessionFactor().openSession();
        List<Operacion_EstadosDocumentos> operacion_estado_documento = null;
        try {
            sesion.beginTransaction();
            operacion_estado_documento = sesion.createCriteria(Operacion_EstadosDocumentos.class).createAlias("documento", "documentoBuscar").add(Restrictions.eq("documentoBuscar.id_documento", Id_documento))
                    .list();
            for (Operacion_EstadosDocumentos operacion_EstadosDocumentos : operacion_estado_documento) {
                auditoria_docuemento.add(sesion.find(AuditoriaDocumento.class, operacion_EstadosDocumentos.getId_operacioEstados()));
            }
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "El error viene de UsuarioExternoImpl:get_auiditoria_find_by_id_documento " + e.getMessage());
        } finally {
            sesion.close();
        }
        return auditoria_docuemento;
    }

}
