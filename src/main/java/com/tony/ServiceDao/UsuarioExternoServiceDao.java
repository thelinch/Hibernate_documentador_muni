/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.tony.models.Documento.Estado_documentos;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface UsuarioExternoServiceDao {

    Estado_documentos get_last_state_find_by_document(int id_documento);

    DefaultTableModel get_documentos_find_by_user_externo(int user_id, JTable tabla);

    void get_auditoria_find_by_id_documento(int Id_documento, JDialog dialog);
}
