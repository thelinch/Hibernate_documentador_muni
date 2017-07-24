/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.tony.DaoImpl.UsuarioExternoImpl;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.tony.ServiceDao.UsuarioExternoServiceDao;
import com.tony.models.Documento.AuditoriaDocumento;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author antony
 */
public class UsuarioExternoServiceImpl implements UsuarioExternoServiceDao {

    private UsuarioExternoImpl usuario_externo = new UsuarioExternoImpl();
    private Object[] colores = {Color.BLUE, Color.GRAY, Color.green, Color.lightGray, Color.TRANSLUCENT};

    @Override
    public Estado_documentos get_last_state_find_by_document(int id_documento) {
        return this.usuario_externo.get_last_state_find_by_document(id_documento);
    }

    @Override
    public DefaultTableModel get_documentos_find_by_user_externo(int user_id, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        List<Documento> documentos = this.usuario_externo.get_documentos_find_by_user_externo(user_id);
        for (Documento documento : documentos) {
            modelo.addRow(new Object[]{documento.getId_documento(), documento.getAsunto(), this.get_last_state_find_by_document(documento.getId_documento()).getEstado()});
        }
        return modelo;
    }

    @Override
    public void get_auditoria_find_by_id_documento(int Id_documento, JDialog dialog2) {
        List<AuditoriaDocumento> documentoAuditoria = this.usuario_externo.get_auditoria_find_by_id_documento(Id_documento);
        int j = 1;

        dialog2.setLayout(new GridLayout(documentoAuditoria.size(), 1));
        //dialog2.removeAll();
        for (Component componente : dialog2.getContentPane().getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panel = (JPanel) componente;
                dialog2.remove(panel);

            }

        }
        for (AuditoriaDocumento auditoriaDocumento : documentoAuditoria) {
            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.setBounds(30, j * 20, 100, 200);
            for (int i = 1; i <= 4; i++) {
                if (i == 1) {
                    panel.add(this.get_label_panel_variable("Anterior:", 40, 20, 40, 100));
                    panel.add(this.get_label_panel_variable(auditoriaDocumento.getEstadoAnterior(), 10, 20, 40, 100));

                } else if (i == 2) {
                    panel.add(this.get_label_panel_variable("Actual:", 40, 60, 40, 100));
                    panel.add(this.get_label_panel_variable(auditoriaDocumento.getEstadoActual(), 10, 60, 40, 100));
                }

            }
            panel.setBackground((Color) this.colores[new Random().nextInt(this.colores.length - 1)]);

            j++;
            dialog2.add(panel);

        }
        // dialog.setMinimumSize(new Dimension(470, j * 220));
    }

    private JLabel get_label_panel_variable(String texto, int x, int y, int with, int height) {
        JLabel label = new JLabel();
        label.setText(texto);
        label.setBounds(x, y, with, height);
        return label;
    }

}
