package com.tony.DaoImpl;

import com.tony.Dao.IDocumento;
import com.tony.Dao.hibernateSession;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DocumentImpl implements IDocumento {

    private final hibernateSession hibernatesesion = hibernateSession.get_instancia_hibernate_session();
    private final Errores error = Errores.get_intancia_error();
//Probado y validado

    @Override
    public UsuarioExterno get_usuario_externo_find_by_documento(Documento documento) {
        Session se = this.hibernatesesion.AbrirSesion();
        UsuarioExterno user = null;
        try {
            user = (UsuarioExterno) se.createNamedQuery("Documento.find_by_usuario_externo").setParameter("id_documento", documento.getId_documento()).uniqueResult();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "Error en DocumentImpl: get_usuario_externo " + e.getMessage());
        }
        return user;
    }
//Terminado y probado

    @Override
    public List<AuditoriaDocumento> get_flujograma_documento(int id_documento) {
        List<AuditoriaDocumento> auditoria = null;
        Session sesion = this.hibernatesesion.AbrirSesion();
        try {
            auditoria = (List<AuditoriaDocumento>) sesion.createCriteria(AuditoriaDocumento.class).createAlias("Operacion_estadoDocumento", "operacion").createAlias("operacion.documento", "documento")
                    .add(Restrictions.eq("documento.id_documento", id_documento)).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "error en DocumentoImpl: get_flujograma_documento " + e.getMessage());
        }
        return auditoria;
    }
//Probado y validado

    @Override
    public Estado_documentos get_last_state_find_by_document(int id_documento) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        Estado_documentos estado = null;
//        List<Estado_documentos> lista = new ArrayList<>();
        try {
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
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:get_ultimo_estado" + e.getMessage());
        }

        return estado;
    }
//Probado y Validado

    @Override
    public Documento get_document_find_by_id_document(int id_document) {
        Documento documento = null;
        Session sesion = this.hibernatesesion.AbrirSesion();
        try {
            documento = (Documento) sesion.createNamedQuery("Documento.find_by_id", Documento.class).setParameter("id_documento", id_document).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Error en DocumentoImpl:get_document_find_by_id_documento " + e.getMessage());
        }
        return documento;
    }
//Probado y validad

    @Override
    public Tipo_Documento get_tipo_document_find_by_documento(int id_documento) {
        Tipo_Documento tipo_documento = null;
        Session se = this.hibernatesesion.AbrirSesion();
        try {
            tipo_documento = (Tipo_Documento) se.createCriteria(Documento.class).add(Restrictions.eq("id_documento", id_documento)).setProjection(Projections.property("tipoDocumento")).uniqueResult();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "Error en DocumentImpl: get_tipo_documento_find_by_documento " + e.getMessage());
        }
        return tipo_documento;
    }

    @Override
    public int get_id_documento() {
        Session sesion = this.hibernatesesion.AbrirSesion();
        try {
            System.out.println(sesion.createCriteria(Documento.class).setProjection(Projections.projectionList().add(Projections.max("id_documento")).add(Projections.property("codigo")).getProjection(1)).uniqueResult());
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Error de DocumentImpl:get_id_documento " + e.getMessage());
        }
        return 1;
    }
}
