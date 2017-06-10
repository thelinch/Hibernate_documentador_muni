/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Tipo_Documento;
import java.util.List;

/**
 *
 * @author antony
 */
public interface ITipo_documento {

    List<Tipo_Documento> all_tipo_documento();

    Tipo_Documento get_tipo_documento_find_by_name(String name);

    List<Documento> all_documento_find_by_id_tipo_documento(int id_tipo_documento);
}
