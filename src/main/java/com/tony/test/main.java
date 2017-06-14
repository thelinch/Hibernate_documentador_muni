/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test;

import com.tony.DaoImpl.DocumentImpl;
import com.tony.DaoImpl.Tipo_documentoImpl;
import com.tony.DaoImpl.UsuarioExternoImpl;

/**
 *
 * @author antony
 */
public class main {

    public static void main(String[] args) {
        Tipo_documentoImpl tipo_documento = new Tipo_documentoImpl();
        DocumentImpl doc = new DocumentImpl();
        System.out.println(doc.get_tipo_document_find_by_documento(1));
        //UsuarioExternoImpl user = new UsuarioExternoImpl();
       // user.get_documentos_find_by_user_externo(1).stream().forEach(System.out::println);
        //doc.get_flujograma_documento(1).stream().forEach(System.out::println);
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
