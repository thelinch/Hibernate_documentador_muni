/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public interface UsuarioInternoServiceDao {

    boolean Registrar_usuarioExterno(UsuarioExterno usuario, Usuario_interno user_interno);

    boolean Registrar_operacion_documento_usuario_interno(Usuario_interno usuarioInterno, Documento documento);

    boolean Enviar_area_documento(Documento documento);

    boolean Editar_documento(Documento documento);

    DefaultTableModel All_usuarios_internos(Usuario_interno Usuario_gerente);

    DefaultTableModel All_usuarios_externos(JTable tabla, int inicio, int Final);

    boolean add_documentoUsuarioExterno(Usuario_interno usuario_interno, UsuarioExterno usuario_externo);

    boolean Derivar_documento(Usuario_interno usuario_interno);

    Estado_documentos get_estado(Documento documento);

    DefaultTableModel get_documentos_find_by_Is_Disconforme(JTable tabla);

    void get_flujograma_documento(int id_documento, JPanel panel);

    UsuarioExterno get_usuario_externo_find_by_dni(int dni);

    void Llenar_panel_field_class(JPanel panel_fields, Object objeto);

    Usuario_interno get_usuario_interno_by_Dni(int dni);

    DefaultTableModel get_all_documento_find_by_usuario_and_state_document(Estado_documento estado_requerido, Tipos_Area area, JTable tabla);

    Documento get_document_find_by_id_document(int id_documento);

    Tupa get_tupa_find_by_asunto(String Asunto);

    boolean add_operacion_estado_documento_usuario_interno(Documento documento, Enum Estado_documento);
}
