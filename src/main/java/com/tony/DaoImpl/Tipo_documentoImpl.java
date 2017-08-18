/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.ITipo_documento;
import com.tony.Dao.hibernateSession;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

public class Tipo_documentoImpl implements ITipo_documento {

    private final hibernateSession hibernateSesion = hibernateSession.get_instancia_hibernateSession();
    private final Errores error = Errores.get_intancia_error();

    public Tipo_documentoImpl() {

    }

    @Override
    public List<Tipo_Documento> all_tipo_documento() {
        Session se = this.hibernateSesion.get_sessionFactor().openSession();
        List<Tipo_Documento> lista_all_tipo_documento = null;
        try {
            se.beginTransaction();
            lista_all_tipo_documento = se.createNamedQuery("tipo_documento.all", Tipo_Documento.class).list();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en Tipo_documentoImpl:all_tipo_documento" + e.getMessage());
        } finally {
            se.close();
        }
        return lista_all_tipo_documento;
    }
//Probado y validado

    @Override
    public Tipo_Documento get_tipo_documento_find_by_name(String name) {
        Tipo_Documento tipo_documento = null;
        Session se = this.hibernateSesion.get_sessionFactor().openSession();

        try {
            se.beginTransaction();
            com.tony.Estados.Tipos_Documento tipo_documento_emun = com.tony.Estados.Tipos_Documento.valueOf(name);
//             se.createNamedQuery("tipo_documento.find_by_name", Tipo_Documento.class).setParameter("nombre", name).getSingleResult();
            tipo_documento = (Tipo_Documento) se.createCriteria(Tipo_Documento.class).add(Restrictions.eq("TipoDocumento", tipo_documento_emun)).uniqueResult();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en Tipo_documentoImpl:get_tipo_documento_find_by_name" + e.getMessage());

        } finally {
            se.close();
        }
        return tipo_documento;
    }
//Probado y validado

    @Override
    public List<Documento> all_documento_find_by_id_tipo_documento(int id_tipo_documento) {
        List<Documento> documentos = null;
        Session sesion = this.hibernateSesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            documentos = sesion.find(Tipo_Documento.class, id_tipo_documento).getDocumentos();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "mensaje de Tipo_documento :all_documento_find_by_id_tipo_documento " + e.getMessage());
        } finally {
            sesion.close();
        }

        return documentos;
    }

    @Override
    public List<Tipo_Documento> get_all_tipo_documento_find_by_userExterno(UsuarioExterno user_externo) {
        List<Tipo_Documento> tipo_documentos = new ArrayList<>();
        Session sesion = this.hibernateSesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            if (user_externo != null) {
                tipo_documentos = sesion.createCriteria(UsuarioExterno.class)
                        .add(Restrictions.idEq(user_externo.getId_persona()))
                        .createAlias("documentos", "doc")
                        .setProjection(Projections.property("doc.tipoDocumento")).setResultTransformer(CriteriaSpecification.PROJECTION).list();
            } else {
                tipo_documentos = sesion.createCriteria(Tipo_Documento.class).list();
            }

            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Ele error viene de Tipo_documento: get_all_tipo_documentos " + e.getMessage());
        } finally {
            sesion.close();
        }
        return tipo_documentos;
    }

}
