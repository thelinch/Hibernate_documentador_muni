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
import java.util.List;
import org.hibernate.Session;


public class Tipo_documentoImpl implements ITipo_documento {

    private final hibernateSession hibernateSesion = hibernateSession.get_instancia_hibernate_session();
    private final Errores error = Errores.get_intancia_error();
    @Override
    public List<Tipo_Documento> all_tipo_documento() {
        Session se = this.hibernateSesion.AbrirSesion();
        List<Tipo_Documento> lista_all_tipo_documento = null;
        try {
            lista_all_tipo_documento = se.createNamedQuery("tipo_documento.all", Tipo_Documento.class).getResultList();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en Tipo_documentoImpl:all_tipo_documento" + e.getMessage());
        }
        return lista_all_tipo_documento;
    }

    @Override
    public Tipo_Documento get_tipo_documento_find_by_name(String name) {
        Tipo_Documento tipo_documento = null;
        Session se = this.hibernateSesion.AbrirSesion();
        try {
            tipo_documento = (Tipo_Documento) se.createNamedQuery("tipo_documento.find_by_name", Tipo_Documento.class).setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en Tipo_documentoImpl:all_tipo_documento" + e.getMessage());

        }
        return tipo_documento;
    }

    @Override
    public List<Documento> all_documento_find_by_id_tipo_documento(int id_tipo_documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
