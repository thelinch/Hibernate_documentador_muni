/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioExterrno.UsuarioExternoNatural;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IUsuario_Externo {
    List<UsuarioExterno> all_usuarios_externo();
}
