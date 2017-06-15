/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test;

import com.tony.Dao.hibernateSession;
import com.tony.DaoImpl.AreaImpl;
import com.tony.DaoImpl.DocumentImpl;
import com.tony.DaoImpl.Tipo_documentoImpl;
import com.tony.DaoImpl.UsuarioExternoImpl;
import com.tony.Estados.Estado_Concluido;
import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipo_Documento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Documento.Concluido;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.UsuarioInterno.Perfil;
import org.hibernate.Session;

public class main {

    private hibernateSession sesionHibernate = hibernateSession.get_instancia_hibernate_session();

    public static void main(String[] args) {
        //main mai = new main()
        AreaImpl area = new AreaImpl();
        area.get_usuarios_interno_find_by_Area_name("pedriatria").forEach(System.out::println);
//        mai.sesionHibernate.AbrirSesion();
//        Tipo_documentoImpl tipo_documento = new Tipo_documentoImpl();
        //        DocumentImpl doc = new DocumentImpl();
        //        System.out.println(doc.get_tipo_document_find_by_documento(1));
        //UsuarioExternoImpl user = new UsuarioExternoImpl();
        // user.get_documentos_find_by_user_externo(1).stream().forEach(System.out::println);
        //doc.get_flujograma_documento(1).stream().forEach(System.out::println);
        //mai.inicio();
    }

    private void inicio() {
        Session sesion = this.sesionHibernate.AbrirSesion();
        for (Estado_Concluido estado_concluido : Estado_Concluido.values()) {
            Concluido con = new Concluido();
            con.setEstadoConcluido(estado_concluido);
            sesion.persist(con);
        }
        for (Tipo_Documento tipodocumento : Tipo_Documento.values()) {
            com.tony.models.Documento.Tipo_Documento tipo = new com.tony.models.Documento.Tipo_Documento();
            tipo.setTipoDocumento(tipodocumento);
            sesion.persist(tipo);
        }
        for (Tipo_Perfil_UsuarioInterno perfil_usuario_interno : Tipo_Perfil_UsuarioInterno.values()) {
            Perfil perfil = new Perfil();
            perfil.setTipoPerfil(perfil_usuario_interno);
            sesion.persist(perfil);
        }
        for (Estado_documento estado_documento : Estado_documento.values()) {
            Estado_documentos estado = new Estado_documentos();
            estado.setEstado(estado_documento);
            sesion.persist(estado);
        }
        sesion.getTransaction().commit();
    }
}
