package com.tony.Vista;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.DaoImpl.Tipo_documentoImpl;
import com.tony.ServiceImpl.Tipo_documentoServiceImpl;
import com.tony.ServiceImpl.UsuarioInternoServiceImpl;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioExterrno.UsuarioExternoJuridico;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class home_de_la_mesa_partes extends javax.swing.JFrame {

    private File archivo;
    private byte[] bytesImg;
    private final UsuarioInternoServiceImpl userInternoService;
    private UsuarioExterno user = null;
    private UsuarioExternoJuridico usuarioExternoJuridico = null;
    private final Documento documentoEdicio = null;

    private final List<Tipo_Documento> tipos_documento = null;
    private final Tipo_documentoServiceImpl tipos_service = new Tipo_documentoServiceImpl();

    public home_de_la_mesa_partes() {
        initComponents();
        this.userInternoService = new UsuarioInternoServiceImpl();
        this.setLocationRelativeTo(null);
        jPanelPersonaJuridica.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDocumentos = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelDocumento = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNombreCodigo_Documento = new javax.swing.JLabel();
        jLabelCodigo_Documento = new javax.swing.JLabel();
        jCheckBoxIsTupac = new javax.swing.JCheckBox();
        jTextFieldAsunto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumeroFolioRequerido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNumeroFolioPresentado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPlazo_resolucion_documento = new javax.swing.JTextField();
        jCheckBox_Conformidad = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButton_SelecionarArchivo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_NombreDelAchivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Descripcion = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextFieldTipo_documento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel_Operador = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel_Funcion = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel_Fecha = new javax.swing.JLabel();
        jLabel_Nombre_operador = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_VISTA = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableVistaDocumento_por_enviar = new javax.swing.JTable();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableVista_documetos_enviados = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel_CONTROL = new javax.swing.JPanel();
        jPanel_Sub_Control = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanelregistro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Apellido = new javax.swing.JLabel();
        jTextField_Apellido = new javax.swing.JTextField();
        jLabel_Correo = new javax.swing.JLabel();
        jTextField_Correo = new javax.swing.JTextField();
        jLabel_DNI = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jLabel_Tipo = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jComboBoxTipoPersona = new javax.swing.JComboBox<>();
        jButton_Aceptar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jPanelPersonaJuridica = new javax.swing.JPanel();
        jLabel_Ruc = new javax.swing.JLabel();
        jTextField_Ruc = new javax.swing.JTextField();
        jLabel_Organizacion = new javax.swing.JLabel();
        jTextField_Organizacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jDialogDocumentos.setAlwaysOnTop(true);
        jDialogDocumentos.setLocation(new java.awt.Point(350, 0));
        jDialogDocumentos.setMinimumSize(new java.awt.Dimension(760, 760));
        jDialogDocumentos.setName("Documento"); // NOI18N
        jDialogDocumentos.setResizable(false);
        jDialogDocumentos.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogDocumentosWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialogDocumentosWindowOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRO DE DOCUMENTO");

        jLabelNombreCodigo_Documento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombreCodigo_Documento.setText("CodigoDocumento");

        jLabelCodigo_Documento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCodigo_Documento.setText("Codigo");

        jCheckBoxIsTupac.setText("Tupa");
        jCheckBoxIsTupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIsTupacActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Asunto");

        jTextFieldArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAreaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Area");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("#Foleo");

        jTextFieldNumeroFolioRequerido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNumeroFolioRequerido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroFolioRequeridoActionPerformed(evt);
            }
        });
        jTextFieldNumeroFolioRequerido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroFolioRequeridoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Presentado");

        jTextFieldNumeroFolioPresentado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNumeroFolioPresentado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroFolioPresentadoActionPerformed(evt);
            }
        });
        jTextFieldNumeroFolioPresentado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroFolioPresentadoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Plazo");

        jCheckBox_Conformidad.setText("Desconforme");
        jCheckBox_Conformidad.setEnabled(false);

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        jScrollPane3.setViewportView(jTextAreaObservaciones);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Observaciones");

        jButton_SelecionarArchivo.setText("Seleccionar Archivo");
        jButton_SelecionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelecionarArchivoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Copia");

        jTextField_NombreDelAchivo.setEditable(false);
        jTextField_NombreDelAchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NombreDelAchivoActionPerformed(evt);
            }
        });

        jTextArea_Descripcion.setColumns(20);
        jTextArea_Descripcion.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Descripcion);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Descripcion");

        jButtonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRegistrar.setText("REGISTRAR");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Resetear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tipo Documento");

        javax.swing.GroupLayout jPanelDocumentoLayout = new javax.swing.GroupLayout(jPanelDocumento);
        jPanelDocumento.setLayout(jPanelDocumentoLayout);
        jPanelDocumentoLayout.setHorizontalGroup(
            jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDocumentoLayout.createSequentialGroup()
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDocumentoLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDocumentoLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDocumentoLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNumeroFolioRequerido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox_Conformidad, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                        .addComponent(jLabelNombreCodigo_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCodigo_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(jCheckBoxIsTupac, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                        .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                        .addGap(188, 188, 188)
                                        .addComponent(jTextFieldNumeroFolioPresentado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDocumentoLayout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldTipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldPlazo_resolucion_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_SelecionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_NombreDelAchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        jPanelDocumentoLayout.setVerticalGroup(
            jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombreCodigo_Documento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCodigo_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxIsTupac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAsunto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTipo_documento))
                .addGap(42, 42, 42)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGroup(jPanelDocumentoLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumeroFolioPresentado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeroFolioRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPlazo_resolucion_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_Conformidad)
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton_SelecionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NombreDelAchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDocumentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanelDocumento);

        javax.swing.GroupLayout jDialogDocumentosLayout = new javax.swing.GroupLayout(jDialogDocumentos.getContentPane());
        jDialogDocumentos.getContentPane().setLayout(jDialogDocumentosLayout);
        jDialogDocumentosLayout.setHorizontalGroup(
            jDialogDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDocumentosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogDocumentosLayout.setVerticalGroup(
            jDialogDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDocumentosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 239, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home De La Mesa Partes");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Del Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 0, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Operador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Operador.setText("Operador");
        jPanel4.add(jLabel_Operador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 28, 123, 25));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 59, 214, 40));

        jLabel_Funcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Funcion.setText("Funcion:");
        jPanel4.add(jLabel_Funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 117, 116, 35));

        jTextField2.setEditable(false);
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 119, 212, 35));

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Fecha.setText("Fecha de ingreso");
        jPanel4.add(jLabel_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 40));

        jLabel_Nombre_operador.setText("Nombre Operador");
        jPanel4.add(jLabel_Nombre_operador, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 28, 208, 25));

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setText("Ingrese la fecha:");

        jTableVistaDocumento_por_enviar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Documento", "Proceso", "Estado Actual", "Persona", "Editar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableVistaDocumento_por_enviar);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Documento por Enviar");

        jTableVista_documetos_enviados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_docuemento", "Proceso", "Estado actual", "Persona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableVista_documetos_enviados);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Documentos Enviados");

        javax.swing.GroupLayout jPanel_VISTALayout = new javax.swing.GroupLayout(jPanel_VISTA);
        jPanel_VISTA.setLayout(jPanel_VISTALayout);
        jPanel_VISTALayout.setHorizontalGroup(
            jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VISTALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_VISTALayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_VISTALayout.createSequentialGroup()
                        .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jPanel_VISTALayout.setVerticalGroup(
            jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VISTALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_VISTALayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(171, Short.MAX_VALUE))
                    .addGroup(jPanel_VISTALayout.createSequentialGroup()
                        .addGroup(jPanel_VISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel_VISTALayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("VISTA", jPanel_VISTA);

        javax.swing.GroupLayout jPanel_Sub_ControlLayout = new javax.swing.GroupLayout(jPanel_Sub_Control);
        jPanel_Sub_Control.setLayout(jPanel_Sub_ControlLayout);
        jPanel_Sub_ControlLayout.setHorizontalGroup(
            jPanel_Sub_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        jPanel_Sub_ControlLayout.setVerticalGroup(
            jPanel_Sub_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_CONTROLLayout = new javax.swing.GroupLayout(jPanel_CONTROL);
        jPanel_CONTROL.setLayout(jPanel_CONTROLLayout);
        jPanel_CONTROLLayout.setHorizontalGroup(
            jPanel_CONTROLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Sub_Control, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_CONTROLLayout.setVerticalGroup(
            jPanel_CONTROLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Sub_Control, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONTROL", jPanel_CONTROL);

        jPanelregistro.setPreferredSize(new java.awt.Dimension(1000, 528));
        jPanelregistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de usuario");
        jPanelregistro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 718, 40));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Nombre.setText("Nombre");
        jPanelregistro.add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 77, 60));

        jTextField_Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NombreActionPerformed(evt);
            }
        });
        jPanelregistro.add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 46, 195, 60));

        jLabel_Apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Apellido.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Apellido.setText("Apellido");
        jPanelregistro.add(jLabel_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, 77, 35));

        jTextField_Apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ApellidoActionPerformed(evt);
            }
        });
        jPanelregistro.add(jTextField_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 112, 195, 35));

        jLabel_Correo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Correo.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_Correo.setText("Correo");
        jPanelregistro.add(jLabel_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 77, 38));

        jTextField_Correo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Correo.setName("noRequerido"); // NOI18N
        jPanelregistro.add(jTextField_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 165, 195, 38));

        jLabel_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_DNI.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_DNI.setText("DNI");
        jPanelregistro.add(jLabel_DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 112, 54, 35));

        jTextFieldDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDniKeyPressed(evt);
            }
        });
        jPanelregistro.add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 112, 167, 35));

        jLabel_Telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_Telefono.setText("Telefono");
        jPanelregistro.add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 166, 65, 34));

        jLabel_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Tipo.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Tipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tipo.setText("Tipo Usuario:");
        jPanelregistro.add(jLabel_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 103, 37));

        jTextField_Telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Telefono.setName("noRequerido"); // NOI18N
        jPanelregistro.add(jTextField_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 166, 164, 35));

        jComboBoxTipoPersona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural", "Juridico" }));
        jComboBoxTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPersonaActionPerformed(evt);
            }
        });
        jPanelregistro.add(jComboBoxTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 209, -1, 37));

        jButton_Aceptar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Aceptar.setText("ACEPTAR");
        jButton_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AceptarActionPerformed(evt);
            }
        });
        jPanelregistro.add(jButton_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 373, 171, 56));

        jButton_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Cancelar.setText("CANCELAR");
        jPanelregistro.add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 374, 163, 55));

        jPanelPersonaJuridica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Obligados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel_Ruc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Ruc.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Ruc.setText("RUC");

        jTextField_Ruc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_Organizacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Organizacion.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Organizacion.setText("Organizacion");

        jTextField_Organizacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelPersonaJuridicaLayout = new javax.swing.GroupLayout(jPanelPersonaJuridica);
        jPanelPersonaJuridica.setLayout(jPanelPersonaJuridicaLayout);
        jPanelPersonaJuridicaLayout.setHorizontalGroup(
            jPanelPersonaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonaJuridicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_Ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Organizacion)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Organizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanelPersonaJuridicaLayout.setVerticalGroup(
            jPanelPersonaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonaJuridicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Organizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPersonaJuridicaLayout.createSequentialGroup()
                        .addGroup(jPanelPersonaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Organizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPersonaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField_Ruc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addComponent(jLabel_Ruc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelregistro.add(jPanelPersonaJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 590, 80));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelregistro, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelregistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO", jPanel3);

        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Datos Requeridos de Color:");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(153, 0, 0));

        jLabel13.setForeground(new java.awt.Color(0, 153, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Datos Opcionales  de Color:");

        jTextField4.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel7);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 890));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxIsTupacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIsTupacActionPerformed
        if (jCheckBoxIsTupac.isSelected() == true) {
            Calendar fecha = new GregorianCalendar();
            jLabelCodigo_Documento.setText(String.valueOf(fecha.get(Calendar.YEAR)) + String.valueOf(fecha.get(Calendar.MONTH)) + String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)));

        }
        if (jCheckBoxIsTupac.isSelected() == false) {
            jLabelCodigo_Documento.setText("");

        }
    }//GEN-LAST:event_jCheckBoxIsTupacActionPerformed

    private void jTextFieldAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAreaActionPerformed

    private void jTextFieldNumeroFolioRequeridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFolioRequeridoActionPerformed
        /**/
    }//GEN-LAST:event_jTextFieldNumeroFolioRequeridoActionPerformed

    private void jTextFieldNumeroFolioRequeridoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFolioRequeridoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numero");
        }
    }//GEN-LAST:event_jTextFieldNumeroFolioRequeridoKeyTyped

    private void jTextFieldNumeroFolioPresentadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFolioPresentadoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numero");
        }
    }//GEN-LAST:event_jTextFieldNumeroFolioPresentadoKeyTyped

    private void jButton_SelecionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelecionarArchivoActionPerformed

//        JFileChooser seleccionado = new JFileChooser();
//        seleccionado.showOpenDialog(jDialogDocumentos);
//        if (seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION) {
//            archivo = seleccionado.getSelectedFile();
//            if (archivo.canRead()) {
//                if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png")) {
//                    
//                    jTextField_NombreDelAchivo.setText(archivo.getName());
//                    bytesImg = registro.AbrirAImagen(archivo);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de imagen.");
//                }
//                
//            }
//        }
    }//GEN-LAST:event_jButton_SelecionarArchivoActionPerformed

    private void jTextField_NombreDelAchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NombreDelAchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NombreDelAchivoActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
//        if (seleccionado.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
//            archivo = seleccionado.getSelectedFile();
//            if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png")) {
//                String respuesta = registro.GuardarImagen(archivo, bytesImg);
//                if (respuesta != null) {
//                    JOptionPane.showMessageDialog(null, respuesta);
//                } else {
//                    JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL ARCHIVO");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "FORMATO INCORRECTO");
//
//            }
//        }
        if (this.userInternoService.VerificacionJpanes(jPanelDocumento)) {
            JOptionPane.showMessageDialog(jDialogDocumentos, "Faltan datos en el documento");
            return;
        } else if (JOptionPane.showConfirmDialog(jDialogDocumentos, "Los datos son correctos?") == 0) {
//            Documento documento = new Documento(jLabelCodigo_Documento.getText(), jTextFieldAsunto.getText(), jTextArea_Descripcion.getText(), jTextAreaObservaciones.getText(), Integer.parseInt(jTextFieldNumeroFolioPresentado.getText()), jCheckBox_Conformidad.isSelected(), jCheckBoxIsTupac.isSelected());
//            //Agregar el tipo del documento en 
//            if (this.usuarioExternoJuridico != null) {
//                this.usuarioExternoJuridico.addDocumento(documento);
//            } else {
//                this.user.addDocumento(documento);
//                
//            }
//            DesktopNotify.showDesktopMessage("Un nuevo Documento fue agregado", "Asunto:" + documento.getAsunto() + " ", DesktopNotify.SUCCESS, 5000);
//            this.userInternoService.CrearIdDocumento(jLabelCodigo_Documento);
            this.userInternoService.limpiarDatosPanel(jPanelDocumento);

        }

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTextFieldNumeroFolioPresentadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFolioPresentadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroFolioPresentadoActionPerformed

    private void jButton_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AceptarActionPerformed
        if (this.userInternoService.VerificacionJpanes(jPanelregistro)) {
            JOptionPane.showMessageDialog(this, "Faltan datos");
            return;
        } else if (jComboBoxTipoPersona.getSelectedItem().toString().equals("Juridico")) {
            if (this.userInternoService.VerificacionJpanes(jPanelPersonaJuridica)) {
                JOptionPane.showMessageDialog(this, "faltan datos en la persona juridica");
                return;
            }
        }
        if (JOptionPane.showConfirmDialog(this, "Son los datos Correctos?") == 0) {
            this.user = new UsuarioExterno(jTextField_Nombre.getText(), jTextField_Apellido.getText(), Integer.parseInt(jTextFieldDni.getText()), jTextField_Correo.getText(), jTextField_Telefono.getText());
            user.setCorreo_electronico(jTextField_Correo.getText());
            if (this.jComboBoxTipoPersona.getSelectedItem().toString().equals("Juridico")) {
                this.usuarioExternoJuridico = new UsuarioExternoJuridico(this.user.getNombre(), this.user.getApellido(), this.user.getDni(), this.user.getCorreo_electronico(), this.user.getTelefono(), Integer.parseInt(jTextField_Ruc.getText()), this.jTextField_Organizacion.getText());
            }
//            this.userInternoService.CrearIdDocumento(jLabelCodigo_Documento);
            jDialogDocumentos.setVisible(true);

        }


    }//GEN-LAST:event_jButton_AceptarActionPerformed

    private void jComboBoxTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPersonaActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoPersona.getSelectedItem().toString().equals("Juridico")) {
            jPanelPersonaJuridica.setVisible(true);
        } else {
            jPanelPersonaJuridica.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxTipoPersonaActionPerformed

    private void jTextField_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ApellidoActionPerformed

    private void jTextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NombreActionPerformed

    private void jTextFieldDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDniKeyPressed
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numero");
        } else if (jTextFieldDni.getText().length() <= 8) {
            jTextFieldDni.setSelectedTextColor(Color.GREEN);
        } else {
            jTextFieldDni.setSelectedTextColor(Color.red);

        }
    }//GEN-LAST:event_jTextFieldDniKeyPressed

    private void jDialogDocumentosWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogDocumentosWindowClosing
//     if (this.usuarioExternoJuridico != null) {
//         //Grre
//            this.userInternoService.   (this.usuarioExternoJuridico);
//        } else {
//            this.user.Add_UsuarioExterno(this.user);
//        }
        this.userInternoService.limpiarDatosPanel(jPanelPersonaJuridica);
        this.userInternoService.limpiarDatosPanel(jPanelregistro);
        this.userInternoService.limpiarDatosPanel(jPanelDocumento);
    }//GEN-LAST:event_jDialogDocumentosWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jDialogDocumentosWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogDocumentosWindowOpened

        TextAutoCompleter texto_autocompletado_tipo_documento = new TextAutoCompleter(jTextFieldTipo_documento);
        TextAutoCompleter texto_autocompletado_area=new TextAutoCompleter(jTextFieldArea);
        TextAutoCompleter texto_autocompletado_asunto=new TextAutoCompleter(jTextFieldAsunto);
        this.tipos_service.LLenar_autcompleter(texto_autocompletado_tipo_documento);
        
        if (jCheckBoxIsTupac.isSelected() && texto_autocompletado_area.getItems().length==0 && texto_autocompletado_asunto.getItems().length==0) {
         
        }else{
            texto_autocompletado_area.removeAllItems();
            texto_autocompletado_asunto.removeAllItems();
        }
    }//GEN-LAST:event_jDialogDocumentosWindowOpened

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(home_de_la_mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_de_la_mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_de_la_mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_de_la_mesa_partes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_de_la_mesa_partes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButton_Aceptar;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_SelecionarArchivo;
    private javax.swing.JCheckBox jCheckBoxIsTupac;
    private javax.swing.JCheckBox jCheckBox_Conformidad;
    private javax.swing.JComboBox<String> jComboBoxTipoPersona;
    private javax.swing.JDialog jDialogDocumentos;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCodigo_Documento;
    private javax.swing.JLabel jLabelNombreCodigo_Documento;
    private javax.swing.JLabel jLabel_Apellido;
    private javax.swing.JLabel jLabel_Correo;
    private javax.swing.JLabel jLabel_DNI;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_Funcion;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre_operador;
    private javax.swing.JLabel jLabel_Operador;
    private javax.swing.JLabel jLabel_Organizacion;
    private javax.swing.JLabel jLabel_Ruc;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_Tipo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelDocumento;
    private javax.swing.JPanel jPanelPersonaJuridica;
    private javax.swing.JPanel jPanel_CONTROL;
    private javax.swing.JPanel jPanel_Sub_Control;
    private javax.swing.JPanel jPanel_VISTA;
    private javax.swing.JPanel jPanelregistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableVistaDocumento_por_enviar;
    private javax.swing.JTable jTableVista_documetos_enviados;
    private javax.swing.JTextArea jTextAreaObservaciones;
    private javax.swing.JTextArea jTextArea_Descripcion;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldAsunto;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNumeroFolioPresentado;
    private javax.swing.JTextField jTextFieldNumeroFolioRequerido;
    private javax.swing.JTextField jTextFieldPlazo_resolucion_documento;
    private javax.swing.JTextField jTextFieldTipo_documento;
    private javax.swing.JTextField jTextField_Apellido;
    private javax.swing.JTextField jTextField_Correo;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_NombreDelAchivo;
    private javax.swing.JTextField jTextField_Organizacion;
    private javax.swing.JTextField jTextField_Ruc;
    private javax.swing.JTextField jTextField_Telefono;
    // End of variables declaration//GEN-END:variables
}
