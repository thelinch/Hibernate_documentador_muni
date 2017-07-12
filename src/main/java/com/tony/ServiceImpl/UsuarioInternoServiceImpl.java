/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.tony.Dao.IVerificacion;
import com.tony.DaoImpl.UsuarioInternoImpl;
import com.tony.ServiceDao.UsuarioInternoServiceDao;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioExterrno.UsuarioExternoJuridico;
import com.tony.models.UsuarioExterrno.UsuarioExternoNatural;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.List;
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
    
    @Override
    public boolean Registrar_usuarioExterno(UsuarioExterno usuario, Usuario_interno user_interno) {
        
        return this.usuariImpl.Registrar_usuario_Externo(usuario, user_interno);
    }
    
    @Override
    public boolean Registrar_operacion_documento_usuario_interno(Usuario_interno usuarioInterno, Documento documento) {
        return this.usuariImpl.add_operacion_documento_usuario_interno(usuarioInterno, documento);
    }
    
    @Override
    public boolean Enviar_area_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean Editar_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public DefaultTableModel get_flujograma_documento(Documento documento) {
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
        for (Documento documento : documentos) {
            objeto[0] = documento.getId_documento();
            objeto[1] = documento.getAsunto();
            objeto[2] = "registrado";
            objeto[3] = documento.getUsuario().getNombre();
            defaultTableModel.addRow(objeto);
        }
        return defaultTableModel;
        
    }
    
}
