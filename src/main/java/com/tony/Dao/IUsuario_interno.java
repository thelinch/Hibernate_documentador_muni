package com.tony.Dao;

import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

public interface IUsuario_interno {

    boolean Registrar_usuario_Externo(UsuarioExterno usuario, Usuario_interno user_interno);

    boolean Registrar_usuario_interno(Usuario_interno user_interno);

    boolean Enviar_area_documento(Documento documento, Usuario_interno userInterno);

    UsuarioExterno get_usuario_externo_find_by_dni(int dni);

    boolean Editar_documento(Documento documento);

    List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente, int inicio);

    List<UsuarioExterno> All_usuarios_externos(int Inicio_paginacion, int Final_paginacion);

    boolean add_documento_a_UsuarioExterno(Usuario_interno usuario_interno, UsuarioExterno usuario_externo);

    Usuario_interno get_usuario_interno_by_Dni(int dni);

    boolean Derivar_documento(Usuario_interno usuario_interno);

    List<Documento> get_documents_find_by_Is_Disconforme();

    boolean add_operacion_documento_usuario_interno(Usuario_interno usuario_interno, Documento document, String Accion);

    boolean add_operacion_estado_documento_usuario_interno(Documento documento, Enum Estado_documento);
//    Estado_documentos get_ultimo_estado(int documento);
//
//    Documento get_find_by_id_documento(int id_documento);
//

    Tupa get_tupa_find_by_asunto(String Asunto);

    Documento get_document_find_by_id_document(int id_documento);

    List<Documento> get_all_documentos_find_by_state(Estado_documento estado_requerido, Tipos_Area area);

    List<AuditoriaDocumento> get_flujograma_documento(int id_documento);

    List<Usuario_interno> get_usuario_interno_find_by_nombre_area(String Area_Nombre);

    List<Area> get_area_find_by_tupa(String nameTupa); //
    //    Tipo_Documento find_by_id_documento(int TipoDocumento);

}
