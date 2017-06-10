package com.tony.ServiceImpl;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class Verificacion {

    protected boolean VerificacionJpanes(JPanel panel) {
        boolean verificacion = false;
        for (Component componentes : panel.getComponents()) {
            if (componentes instanceof JTextField) {
                JTextField caja = (JTextField) componentes;

                if (caja.getName() == null && caja.getText().equals("")) {
                    verificacion = true;
                    break;
                }
            } else if (componentes instanceof JTextArea) {
                JTextArea are = (JTextArea) componentes;
                if (are.getName() == null && are.getText().equals("")) {
                    verificacion = true;
                    break;
                }
            }
        }
        return verificacion;
    }

    protected void limpiarDatosPanel(JPanel panel) {
        for (Component componentes : panel.getComponents()) {
            if (componentes instanceof JTextField) {
                JTextField caja = (JTextField) componentes;
                caja.setText("");
            }
            if (componentes instanceof JTextArea) {
                JTextArea Are = (JTextArea) componentes;
                Are.setText("");
            }
        }
    }
}
