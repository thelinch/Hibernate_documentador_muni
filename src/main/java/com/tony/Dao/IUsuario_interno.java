/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IUsuario_interno {

    boolean Registrar_usuario_Externo(UsuarioExterno usuario);

    boolean Registrar_documento(Usuario_interno usuarioInterno, Documento documento, UsuarioExterno usuarioExterno);

    boolean Enviar_area_documento(Documento documento);

    boolean Editar_documento(Documento documento);

    List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente, int inicio, int Final);

    List<UsuarioExterno> All_usuarios_externos(int Inicio_paginacion, int Final_paginacion);

    boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo);

    boolean Derivar_documento(Usuario_interno usuario_interno);

//    Estado_documentos get_ultimo_estado(int documento);
//
//    Documento get_find_by_id_documento(int id_documento);
//
//    List<Operacion_EstadosDocumentos> get_flujograma_documento(Documento documento);
//
//    Tipo_Documento find_by_id_documento(int TipoDocumento);
}
