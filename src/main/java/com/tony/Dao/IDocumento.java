/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IDocumento {

    UsuarioExterno get_usuario_externo_find_by_documento(Documento documento);

    List<AuditoriaDocumento> get_flujograma_documento(int id_documento);

    Estado_documentos get_last_state_find_by_document(int id_documento);

    Documento get_document_find_by_id_document(int id_document);

    Tipo_Documento get_tipo_document_find_by_documento(int id_documento);

    int get_id_documento();
    

}
