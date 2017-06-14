/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.tony.Dao.IVerificacion;
import com.tony.DaoImpl.UsuarioInternoImpl;
import com.tony.ServiceImpl.Verificacion;
import com.tony.ServiceDao.UsuarioInternoServiceDao;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public class UsuarioInternoServiceImpl extends Verificacion implements UsuarioInternoServiceDao, IVerificacion {
    
    private UsuarioInternoImpl usuariImpl = new UsuarioInternoImpl();
    
    @Override
    public boolean Registrar_usuarioExterno(UsuarioExterno usuario,Usuario_interno user_interno) {
        
        return this.usuariImpl.Registrar_usuario_Externo(usuario,user_interno);
    }
    
    @Override
    public boolean Registrar_operacion_documento_usuario_interno(Usuario_interno usuarioInterno, Documento documento) {
        return this.usuariImpl.add_operacion_documento_usuario_interno(usuarioInterno,documento);
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
    public boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

   

    
    
}
