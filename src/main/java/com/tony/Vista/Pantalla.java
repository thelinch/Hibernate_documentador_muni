/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Vista;

import java.util.Objects;
import javax.swing.JInternalFrame;

/**
 *
 * @author antony
 */
public class Pantalla {

    private String nombre;
    private boolean activado = false;
    private JInternalFrame frame;

    public Pantalla(String nombre, boolean activado) {
        this.nombre = nombre;
        this.activado = activado;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public String getNombre() {
        return nombre;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    @Override
    public String toString() {
        return "Pantalla{" + "nombre=" + nombre + ", activado=" + activado + ", frame=" + frame + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.frame);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pantalla other = (Pantalla) obj;
        if (!Objects.equals(this.frame, other.frame)) {
            return false;
        }
        return true;
    }
    

}
