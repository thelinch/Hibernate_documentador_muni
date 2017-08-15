/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.Dao.IVerificacion;
import com.tony.DaoImpl.UsuarioInternoImpl;
import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.ServiceDao.UsuarioInternoServiceDao;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioExterrno.UsuarioExternoJuridico;
import com.tony.models.UsuarioExterrno.UsuarioExternoNatural;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public class UsuarioInternoServiceImpl extends Verificacion implements UsuarioInternoServiceDao, IVerificacion {

    private final UsuarioInternoImpl usuariImpl = new UsuarioInternoImpl();
    private final Object[] colores = {Color.BLUE, Color.GRAY, Color.green, Color.lightGray, Color.TRANSLUCENT, Color.CYAN, Color.BITMASK, Color.ORANGE, Color.PINK};

    @Override
    public boolean Registrar_usuarioExterno(UsuarioExterno usuario, Usuario_interno user_interno) {

        return this.usuariImpl.Registrar_usuario_Externo(usuario, user_interno);
    }

    @Override
    public boolean Registrar_operacion_documento_usuario_interno(Usuario_interno usuarioInterno, Documento documento, String accion) {
        return this.usuariImpl.add_operacion_documento_usuario_interno(usuarioInterno, documento, accion);
    }

    @Override
    public boolean Enviar_area_documento(Documento documento, Usuario_interno user_interno) {
        return this.usuariImpl.Enviar_area_documento(documento, user_interno);
    }

    @Override
    public boolean Editar_documento(Documento documento) {
        return this.usuariImpl.Editar_documento(documento);
    }

    @Override
    public DefaultTableModel All_usuarios_internos(Usuario_interno Usuario_gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel All_usuarios_externos(JTable tabla, int inicio, int Final) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        List<UsuarioExterno> usuariosExternos = this.usuariImpl.All_usuarios_externos(inicio, Final);
        return modelo;

    }

    @Override
    public boolean add_documentoUsuarioExterno(Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        return this.usuariImpl.add_documento_a_UsuarioExterno(usuario_interno, usuario_externo);
    }

    @Override
    public boolean Derivar_documento(Usuario_interno usuario_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado_documentos get_estado(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean VerificacionJpanes(JPanel panel) {
        return super.VerificacionJpanes(panel);
    }

    @Override
    public void limpiarDatosPanel(JPanel panel) {
        super.limpiarDatosPanel(panel);
    }

    @Override
    public UsuarioExterno get_usuario_externo_find_by_dni(int dni) {
        return this.usuariImpl.get_usuario_externo_find_by_dni(dni); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Llenar_panel_field_class(JPanel panel_fields, Object objeto) {
        Field properties[] = null;
        Tupa tupac = null;
        if (objeto instanceof UsuarioExternoJuridico) {
            UsuarioExternoJuridico user_juridico;
            user_juridico = (UsuarioExternoJuridico) objeto;
            Class _clas = UsuarioExternoJuridico.class;
            properties = _clas.getDeclaredFields();

            System.out.println("entro al usuarioExternoJuridico");
        } else if (objeto instanceof UsuarioExternoNatural) {
            UsuarioExternoNatural user_natural = (UsuarioExternoNatural) objeto;
            Class _clas_user_natural = UsuarioExternoNatural.class;
            properties = _clas_user_natural.getFields();
            System.out.println("entro al usuarioExternoNatrual  ");

        } else if (objeto instanceof Tupa) {
            //Falta hacer de tupa

            Class _clase = Tupa.class;
            properties = _clase.getDeclaredFields();
        }
        int i = 0;
        for (Component componentes : panel_fields.getComponents()) {
            if (componentes instanceof JTextField) {
                JTextField field = (JTextField) componentes;
                if (field.getToolTipText().equals(properties[i].getName()) && tupac != null) {
                }
            }
            i++;
        }

    }

    @Override
    public Usuario_interno get_usuario_interno_by_Dni(int dni) {
        return this.usuariImpl.get_usuario_interno_by_Dni(dni);
    }

    @Override
    public DefaultTableModel get_documentos_find_by_Is_Disconforme(JTable tabla) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tabla.getModel();
        defaultTableModel.setRowCount(0);
        List<Documento> documentos = this.usuariImpl.get_documents_find_by_Is_Disconforme();
        Object[] objeto = new Object[documentos.size()];
        documentos.stream().map((documento) -> {
            objeto[0] = documento.getId_documento();
            return documento;
        }).map((documento) -> {
            objeto[1] = documento.getAsunto();
            return documento;
        }).map((documento) -> {
            objeto[2] = "registrado";
            objeto[3] = documento.getUsuario().getNombre();
            return documento;
        }).forEach((_item) -> {
            defaultTableModel.addRow(objeto);
        });
        return defaultTableModel;

    }

    @Override
    public boolean add_operacion_estado_documento_usuario_interno(Documento documento, Enum Estado_documento) {
        return this.usuariImpl.add_operacion_estado_documento_usuario_interno(documento, Estado_documento);
    }

    @Override
    public void get_flujograma_documento(int id_documento, JPanel panel) {
        List<AuditoriaDocumento> documentoAuditoria = this.usuariImpl.get_flujograma_documento(id_documento);
        //dialog2.removeAll();
        int numero_paneles = 0;
        panel.setLayout(new GridLayout(documentoAuditoria.size(), 1));
        for (Component componente : panel.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panel_instancia = (JPanel) componente;
                panel.remove(panel_instancia);
            }

        }
        for (AuditoriaDocumento auditoriaDocumento : documentoAuditoria) {
            JPanel panel_2 = new JPanel(new GridLayout(3, 2));
            panel_2.add(this.get_label_panel_variable("Fecha :", 40, 20, 40, 100));
            panel_2.add(this.get_label_panel_variable(auditoriaDocumento.getFecha() == null ? "no hay fecha " : auditoriaDocumento.getFecha().toString(), 10, 20, 40, 100));

            for (int i = 1; i <= 4; i++) {
                if (i == 1) {
                    panel_2.add(this.get_label_panel_variable("Anterior:", 40, 20, 40, 100));
                    panel_2.add(this.get_label_panel_variable(auditoriaDocumento.getEstadoAnterior(), 10, 20, 40, 100));
                } else if (i == 2) {
                    panel_2.add(this.get_label_panel_variable("Actual:", 40, 60, 40, 100));
                    panel_2.add(this.get_label_panel_variable(auditoriaDocumento.getEstadoActual(), 10, 60, 40, 100));
                }
            }
            //panel_2.setBackground((Color) this.colores[Math.round(new Random().nextInt(this.colores.length - 1))]);
            numero_paneles++;
            panel_2.setSize(100, 4 * 100);
            panel_2.setBorder(BorderFactory.createEtchedBorder());
            panel.add(panel_2);
        }
        panel.setSize(100, numero_paneles * 120);

    }

    private JLabel get_label_panel_variable(String texto, int x, int y, int with, int height) {
        JLabel label = new JLabel();
        label.setText(texto);
        label.setBounds(x, y, with, height);
        return label;
    }

    @Override
    public DefaultTableModel get_all_documento_find_by_usuario_and_state_document(Estado_documento estado_requerido, Tipos_Area area, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        List<Documento> documentos = this.usuariImpl.get_all_documentos_find_by_state(estado_requerido, area);
        documentos.stream().forEach((documento) -> {
            modelo.addRow(new Object[]{documento.getId_documento(), documento.getAsunto(), documento.getUsuario().getNombre(), documento.getUsuario().getDni(), documento.isDisconforme() ? "disconforme" : "conforme"});
        });
        return modelo;
    }

    @Override
    public Documento get_document_find_by_id_document(int id_documento) {
        return this.usuariImpl.get_document_find_by_id_document(id_documento);
    }

    @Override
    public Tupa get_tupa_find_by_asunto(String Asunto) {
        return this.usuariImpl.get_tupa_find_by_asunto(Asunto);
    }

    @Override
    public void get_area_find_by_tupa(String nameTupa, TextAutoCompleter llenar_area) {
        this.usuariImpl.get_area_find_by_tupa(nameTupa).stream().forEach((area) -> {
            llenar_area.addItem(area.getTipoArea());
        });
        llenar_area.setCaseSensitive(true);
        llenar_area.setMode(0);

    }

    @Override
    public List<Usuario_interno> get_usuario_interno_find_by_nombre_area(String Area_Nombre, TextAutoCompleter llenar_trabajadores) {
        llenar_trabajadores.removeAllItems();
        List<Usuario_interno> usuario_interno = this.usuariImpl.get_usuario_interno_find_by_nombre_area(Area_Nombre).stream().filter((trabajadores) -> {
            return trabajadores.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Administrador) == 0 ? true : false;
        }).collect(Collectors.toList());
        if (!usuario_interno.isEmpty()) {
            usuario_interno.stream().map(Usuario_interno::getNombre).forEach((nombre_persona) -> {
                llenar_trabajadores.addItem(nombre_persona);
            });
            llenar_trabajadores.setMode(0);
            llenar_trabajadores.setCaseSensitive(true);
        }

        return usuario_interno;
    }

}
