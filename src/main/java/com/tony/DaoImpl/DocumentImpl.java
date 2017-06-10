package com.tony.DaoImpl;

import com.tony.Dao.IDocumento;
import com.tony.Dao.hibernateSession;
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

    @Override
    public List<Operacion_EstadosDocumentos> get_flujograma_documento(int id_documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado_documentos get_last_state_find_by_document(int id_documento) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        Estado_documentos estado = null;
//        List<Estado_documentos> lista = new ArrayList<>();
        try {
            sesionhi.getTransaction().begin();
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

    @Override
    public Documento get_document_find_by_id_document(int id_document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo_Documento get_tipo_document_find_by_documento(int id_documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get_id_documento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
