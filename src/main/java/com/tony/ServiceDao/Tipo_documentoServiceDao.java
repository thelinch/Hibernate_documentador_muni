/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Tipo_Documento;
import java.awt.Label;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author antony
 */
public interface Tipo_documentoServiceDao {

    List<Tipo_Documento> all_tipo_documento();

    Tipo_Documento get_tipo_documento_find_by_name(String name);

    List<Documento> all_documento_find_by_id_tipo_documento(int id_tipo_documento);

    void find_by_name(String name, JLabel receptor_tipo_documento);
}
