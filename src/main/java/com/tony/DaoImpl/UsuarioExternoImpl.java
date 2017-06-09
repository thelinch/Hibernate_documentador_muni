/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_Externo;
import com.tony.Dao.hibernateSession;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;

/**
 *
 * @author antony
 */
public class UsuarioExternoImpl implements IUsuario_Externo {

    private hibernateSession sesion;

    public UsuarioExternoImpl() {
        this.sesion = new hibernateSession();
    }

    @Override
    public List<UsuarioExterno> all_usuarios_externo() {
       return this.sesion.getSesion().createCriteria(UsuarioExterno.class).list();
    }

}
