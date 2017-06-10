/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.models.Documento.Tipo_Documento;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public interface Tipo_documentoServiceDao {


    void find_by_name(String name, JLabel receptor_tipo_documento);

    void all_documento_find_by_id_tipo_documento(int id_tipo_documento);
}
