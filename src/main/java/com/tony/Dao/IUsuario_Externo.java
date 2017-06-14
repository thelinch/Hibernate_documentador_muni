/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IUsuario_Externo {

   

    Estado_documentos get_last_state_find_by_document(int id_documento);

    List<Documento> get_documentos_find_by_user_externo(int  user_id);
    
}
