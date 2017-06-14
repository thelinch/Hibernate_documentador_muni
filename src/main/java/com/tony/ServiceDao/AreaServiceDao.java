/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

public interface AreaServiceDao {

    List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre);
}
