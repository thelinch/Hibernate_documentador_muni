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
import com.tony.DaoImpl.UsuarioInternoImpl;
import com.tony.Estados.Estado_Concluido;
import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipos_Documento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.ServiceImpl.UsuarioInternoServiceImpl;
import com.tony.models.Documento.Concluido;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExternoNatural;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Perfil;
import com.tony.models.UsuarioInterno.Usuario_interno;
import org.hibernate.Session;

public class main {
    
    public static void main(String[] args) {
//        Tipo_documentoImpl tipo = new Tipo_documentoImpl();
//        UsuarioInternoServiceImpl userInternoService = new UsuarioInternoServiceImpl();
//        Usuario_interno usuerio_interno = userInternoService.get_usuario_interno_by_Dni(71837677);
//        System.out.println("Nombre " + usuerio_interno.getNombre() + " dni " + usuerio_interno.getDni());
//        Documento doc = new Documento("dwdwd", tipo.get_tipo_documento_find_by_name(Tipos_Documento.Expediente.toString()), null, null, 7, true, true);
//        UsuarioExternoNatural user = new UsuarioExternoNatural("tony", "lol", 47440, null, null);
//        user.setCodigo("ap");
//        user.addDocumento(doc);
//        userInternoService.Registrar_usuarioExterno(user, usuerio_interno);
//        userInternoService.Registrar_operacion_documento_usuario_interno(usuerio_interno, doc);
//        userInternoService.add_operacion_estado_documento_usuario_interno(doc, Estado_documento.Recepcionado);

        DocumentImpl docu = new DocumentImpl();
        docu.get_all_documentos_find_by_state(Estado_documento.Recepcionado, Tipos_Area.Tramite_Documentario_y_Archivo_Central);
//        UsuarioExternoImpl usuarioExterno = new UsuarioExternoImpl();
//        usuarioExterno.get_auditoria_find_by_id_documento(2).forEach(System.out::println);//main mai = new main()
        //        mai.sesionHibernate.AbrirSesion();
        //        Tipo_documentoImpl tipo_documento = new Tipo_documentoImpl();
        //        DocumentImpl doc = new DocumentImpl();
        //        System.out.println(doc.get_tipo_document_find_by_documento(1));
        //UsuarioExternoImpl user = new UsuarioExternoImpl();
        // user.get_documentos_find_by_user_externo(1).stream().forEach(System.out::println);
        //doc.get_flujograma_documento(1).stream().forEach(System.out::println);
        //mai.inicio();
//        main main = new main();
//        main.inicio();
    }
    
    private void inicio() {
        Session sesion = hibernateSession.get_instancia_hibernateSession().get_sessionFactor().openSession();
        sesion.beginTransaction();
        for (Estado_Concluido estado_concluido : Estado_Concluido.values()) {
            Concluido con = new Concluido();
            con.setEstadoConcluido(estado_concluido);
            sesion.persist(con);
        }
        for (Tipos_Documento tipodocumento : Tipos_Documento.values()) {
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
        for (Tipos_Area area : Tipos_Area.values()) {
            Area areaim = new Area();
            areaim.setTipoArea(area);
            sesion.persist(areaim);
        }
        sesion.getTransaction().commit();
    }
}
