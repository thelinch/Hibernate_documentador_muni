/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceDao;

import com.mxrck.autocompleter.AutoCompleter;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.models.Tupa;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

public interface AreaServiceDao {

    List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre);

    void create_area(Area area);

    void destroy_area(int id_area);

    void updat_area(Area area);

    Area get_area_find_by_id(int id_area);

    List<Area> get_all_area();

    List<Tupa> get_tupa_find_by_area_name(String name_area);

    void llenar_autocompletar_tupa(String nombre_area,TextAutoCompleter autocomplete);
}
