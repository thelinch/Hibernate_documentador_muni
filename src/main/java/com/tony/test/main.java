/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test;

import com.tony.Dao.hibernateSession;
import com.tony.DaoImpl.UsuarioExternoImpl;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioInterno.Perfil;
import org.hibernate.Session;

/**
 *
 * @author antony
 */
public class main {

    hibernateSession sesion = hibernateSession.get_instancia_hibernate_session();

    public static void main(String[] args) {
        UsuarioExternoImpl user = new UsuarioExternoImpl();
        main ma=new main();
      Session sesionhi= ma.sesion.AbrirSesion();
        sesionhi.createCriteria(Perfil.class).list().stream().forEach(System.out::println);
        sesionhi.getTransaction().commit();
        Session se2 = ma.sesion.AbrirSesion();
        se2.createCriteria(Tipo_Documento.class).list().stream().forEach(System.out::println);
        se2.getTransaction().commit();
        //user.all_usuarios_externo().forEach(System.out::println);
        //  inicio();
    }

//    private static void inicio() {
//       
//        for (Estado_Concluido estado_concluido : Estado_Concluido.values()) {
//            Concluido con = new Concluido();
//            con.setEstadoConcluido(estado_concluido);
//            sesion.getSesion().persist(con);
//        }
//        for (Tipo_Documento tipodocumento : Tipo_Documento.values()) {
//            com.tony.models.Documento.Tipo_Documento tipo=new com.tony.models.Documento.Tipo_Documento();
//            tipo.setTipoDocumento(tipodocumento);
//            sesion.getSesion().persist(tipo);
//        }
//        for (Tipo_Perfil_UsuarioInterno perfil_usuario_interno : Tipo_Perfil_UsuarioInterno.values()) {
//            Perfil perfil=new Perfil();
//            perfil.setTipoPerfil(perfil_usuario_interno);
//            sesion.getSesion().persist(perfil);
//        }
//        for (Estado_documento estado_documento :Estado_documento.values()) {
//            Estado_documentos estado=new Estado_documentos();
//            estado.setEstado(estado_documento);
//            sesion.getSesion().persist(estado);
//        }
//        sesion.getSesion().getTransaction().commit();
//    }
}
