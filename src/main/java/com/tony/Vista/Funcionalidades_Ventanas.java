/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Vista;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Funcionalidades_Ventanas {
    
    private ArrayList<Pantalla> total_pantallas = null;
    //private ArrayList<JInternalFrame> internal_frames = null;

    public Funcionalidades_Ventanas() {
        this.total_pantallas = new ArrayList<>();
        //   this.internal_frames = new ArrayList<>();
    }

//    public ArrayList<JInternalFrame> getInternal_frames() {
//        return internal_frames;
//    }
    public ArrayList<Pantalla> getTotal_pantallas() {
        return total_pantallas;
    }

//    public void add_frame_by_Jdesktop(JDesktopPane Jdesktop) {
//        for (int i = 0; i < this.total_pantallas.size(); i++) {
//            if (!this.contains_frame(this.total_pantallas.get(i).getFrame(), Jdesktop)) {
//                Jdesktop.add(this.total_pantallas.get(i).getFrame());
//            }
//        }
//
////        for (int i = 0; i < this.total_pantallas.size(); i++) {
////            if (this.internal_frames.get(i).getName().equalsIgnoreCase(this.total_pantallas.get(i).getNombre()) && !this.contains_frame(this.internal_frames.get(i), Jdesktop)) {
////                this.total_pantallas.get(i).setFrame(this.internal_frames.get(i));
////                Jdesktop.add(this.internal_frames.get(i), i);
////            }
////        }
//    }
    public boolean set_frame_by_total_frame_and_add_frame_by_desktop(JInternalFrame frame, JDesktopPane desktop) {
        Pantalla pantalla = new Pantalla(frame.getName(), false);
        pantalla.setFrame(frame);
        if (!this.total_pantallas.contains(pantalla)) {
            for (int i = 0; i < this.total_pantallas.size(); i++) {
                if (this.total_pantallas.get(i).getNombre().equalsIgnoreCase(frame.getName())) {
                    this.total_pantallas.set(i, pantalla);
                    desktop.add(frame);
                    
                    return true;
                }
            }
            
        }
        
        return false;
    }

    public void Cerrar_todas_ventanas() {
        
    }
//    public void add_internal_frames(JInternalFrame frame) {
//        Pantalla pan = new Pantalla("ddw", false);
//        pan.setFrame(frame);
//        if (!this.total_pantallas.contains(pan)) {
//            this.internal_frames.add(frame);
//        }
//
//    }

    public void add_Pantallas_from_total_pantallas(Pantalla pantalla) {
        this.total_pantallas.add(pantalla);
    }
//
//    private boolean contains_frame(JInternalFrame frame, JDesktopPane jdesktop) {
//        JInternalFrame[] JInternalframes = jdesktop.getAllFrames();
//        for (JInternalFrame JInternalframe : JInternalframes) {
//            if (frame.getName().equalsIgnoreCase(JInternalframe.getName())) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public void Visualizar_Pantalla(String Nombre, Component component) {
        try {
            this.total_pantallas.stream().forEach((pantalla) -> {
                if (pantalla.getNombre().equalsIgnoreCase(Nombre) && pantalla.getFrame() != null) {
                    if (pantalla.getFrame().isShowing()) {
                        JOptionPane.showMessageDialog(component, "La ventana " + pantalla.getNombre() + " se encuentra activa");
                    }
                    pantalla.getFrame().show();
                    pantalla.setActivado(true);
                } else if (pantalla.isActivado() && pantalla.getFrame() != null) {
                    pantalla.getFrame().show(false);
                    pantalla.setActivado(false);
                }
                
            });
        } catch (Exception e) {
            System.out.println("El error viene de Funcionalidades_Ventanas:Visualizar_Pantalla " + e.getMessage());
        }
        
    }
}
