/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_Externo;
import com.tony.Dao.hibernateSession;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author antony
 */
public class UsuarioExternoImpl implements IUsuario_Externo {

    private final hibernateSession sesion = hibernateSession.get_instancia_hibernate_session();

    public UsuarioExternoImpl() {
    }

    @Override
    public Estado_documentos get_last_state_find_by_document(int id_documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Documento> get_documentos_find_by_user_externo(UsuarioExterno user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
