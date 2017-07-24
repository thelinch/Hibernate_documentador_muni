/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Vista;

import com.tony.ServiceImpl.UsuarioInternoServiceImpl;
import com.tony.models.Documento.Documento;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author antony
 */
public class Principal_Mesa_partes extends javax.swing.JFrame {

    private Registro_Usuario_documentos registro_usuario = null;
    private Edicion_documentos_Jinternal_frame_Mesa_Partes edicion_documentos = null;
    private final Funcionalidades_Ventanas funcionalidades_ventanas = new Funcionalidades_Ventanas();
    public static Usuario_interno usuario_interno;
    public static UsuarioInternoServiceImpl userInternoService = null;
    private Documento documentoEdicio = null;

    public Principal_Mesa_partes() {
        initComponents();
        this.init();
        this.userInternoService = new UsuarioInternoServiceImpl();
        this.usuario_interno = this.userInternoService.get_usuario_interno_by_Dni(123);
        this.jLabelNombre.setText(this.usuario_interno.getNombre() + " " + this.usuario_interno.getApellido());
        this.jLabelArea.setText(this.usuario_interno.getArea().getTipoArea().toString());
        this.jLabelFuncion.setText(this.usuario_interno.getPerfil().getTipoPerfil().toString());
        this.jLabelCorreo.setText(this.usuario_interno.getCorreo_electronico());

    }

    private void init() {
        Component[] componentes_principal = this.jPanelPrincipal.getComponents();
        for (Component component : componentes_principal) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                for (Component component1 : panel.getComponents()) {
                    if (component1 instanceof JLabel) {
                        JLabel label = (JLabel) component1;
                        if (label.getName() != null && label.getName().equalsIgnoreCase("item label")) {
                            Pantalla pantalla = new Pantalla(label.getText(), false);
                            this.funcionalidades_ventanas.add_Pantallas_from_total_pantallas(pantalla);
                        }
                    }
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jCPanel1 = new com.bolivia.panel.JCPanel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelArea = new javax.swing.JLabel();
        jLabelFuncion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelEdicionDocumentos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelAgregarUsuario = new javax.swing.JPanel();
        jLabelMenu_agregar_usuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCPanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Paisaje.jpg"))); // NOI18N
        jCPanel1.setVisibleLogo(false);
        jCPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCPanel1MouseClicked(evt);
            }
        });

        jPanelPrincipal.setBackground(new java.awt.Color(56, 9, 121));

        jPanel2.setBackground(new java.awt.Color(73, 10, 159));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Area");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Funcion:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre:");

        jLabelNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(153, 153, 255));
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("tony");

        jLabelArea.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelArea.setForeground(new java.awt.Color(153, 153, 255));
        jLabelArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelArea.setText("tony");

        jLabelFuncion.setForeground(new java.awt.Color(153, 153, 255));
        jLabelFuncion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFuncion.setText("tony");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Correo:");

        jLabelCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(153, 153, 255));
        jLabelCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCorreo.setText("tony");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Documento/ic_account_circle_white_24dp_2x.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelEdicionDocumentos.setBackground(new java.awt.Color(100, 32, 194));
        jPanelEdicionDocumentos.setName("item"); // NOI18N
        jPanelEdicionDocumentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Documento/ic_edit_white_36dp_2x.png"))); // NOI18N
        jPanelEdicionDocumentos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 61));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edicion de Documentos");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setName("item label"); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanelEdicionDocumentos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 240, 61));

        jPanelAgregarUsuario.setBackground(new java.awt.Color(100, 32, 194));
        jPanelAgregarUsuario.setName("item"); // NOI18N
        jPanelAgregarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMenu_agregar_usuario.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelMenu_agregar_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu_agregar_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu_agregar_usuario.setText("Agregar Usuario");
        jLabelMenu_agregar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMenu_agregar_usuario.setName("item label"); // NOI18N
        jLabelMenu_agregar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMenu_agregar_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMenu_agregar_usuarioMouseEntered(evt);
            }
        });
        jPanelAgregarUsuario.add(jLabelMenu_agregar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 0, 230, 57));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Documento/ic_group_add_white_36dp_2x.png"))); // NOI18N
        jPanelAgregarUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 60));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelEdicionDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEdicionDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jCPanel1Layout = new javax.swing.GroupLayout(jCPanel1);
        jCPanel1.setLayout(jCPanel1Layout);
        jCPanel1Layout.setHorizontalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1026, Short.MAX_VALUE))
        );
        jCPanel1Layout.setVerticalGroup(
            jCPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCPanel1Layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jCPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMenu_agregar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenu_agregar_usuarioMouseClicked
        // TODO add your handling code here:
        this.registro_usuario = Registro_Usuario_documentos.get_instancia_registro_usuario();
        this.funcionalidades_ventanas.set_frame_by_total_frame_and_add_frame_by_desktop(this.registro_usuario, this.jDesktopPane1);
        this.funcionalidades_ventanas.Visualizar_Pantalla(this.registro_usuario.getName(), this);

    }//GEN-LAST:event_jLabelMenu_agregar_usuarioMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.edicion_documentos = Edicion_documentos_Jinternal_frame_Mesa_Partes.get_instancia_Edicion_Documentos();
        this.funcionalidades_ventanas.set_frame_by_total_frame_and_add_frame_by_desktop(this.edicion_documentos, jDesktopPane1);
        this.funcionalidades_ventanas.Visualizar_Pantalla(this.edicion_documentos.getName(), this);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jCPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCPanel1MouseClicked
        this.funcionalidades_ventanas.getTotal_pantallas().forEach((pantalla) -> {
            if (pantalla.getFrame() != null && pantalla.getFrame().isShowing()) {

                pantalla.getFrame().show(false);
                pantalla.setActivado(false);

            }

        });
    }//GEN-LAST:event_jCPanel1MouseClicked


    private void jLabelMenu_agregar_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenu_agregar_usuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelMenu_agregar_usuarioMouseEntered
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal_Mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_Mesa_partes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bolivia.panel.JCPanel jCPanel1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelFuncion;
    private javax.swing.JLabel jLabelMenu_agregar_usuario;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAgregarUsuario;
    private javax.swing.JPanel jPanelEdicionDocumentos;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
