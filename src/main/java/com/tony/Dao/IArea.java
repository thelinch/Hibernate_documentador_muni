/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Dao;

import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

/**
 *
 * @author antony
 */
public interface IArea {

    List<Area> get_all_area();

    List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre);
}
