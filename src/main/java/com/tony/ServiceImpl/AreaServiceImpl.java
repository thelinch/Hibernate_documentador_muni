/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.DaoImpl.AreaImpl;
import com.tony.Estados.Tipos_Area;
import com.tony.ServiceDao.AreaServiceDao;
import com.tony.ServiceDao.LLenar_autocompletar;
import com.tony.models.Tupa;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author antony
 */
public class AreaServiceImpl implements AreaServiceDao, LLenar_autocompletar {

    private final AreaImpl areimpl = new AreaImpl();

    @Override
    public List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LLenar_autcompleter(TextAutoCompleter llenar_auto_completar) {
        this.areimpl.get_all_area().stream().forEach((area) -> {
            llenar_auto_completar.addItem(area.getTipoArea());
        });
        llenar_auto_completar.setMode(0);
        llenar_auto_completar.setCaseSensitive(true);
    }

    @Override
    public void create_area(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy_area(int id_area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updat_area(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Area get_area_find_by_id(int id_area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Area> get_all_area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tupa> get_tupa_find_by_area_name(String name_area) {
        return this.areimpl.get_tupa_find_by_area_name(name_area);
    }

    @Override
    public void llenar_autocompletar_tupa(String nombre_area, TextAutoCompleter autocomplete) {
        if (autocomplete.getItems().length != 0) {
            autocomplete.removeAllItems();
        }
        this.get_tupa_find_by_area_name(nombre_area).stream().forEach((tupa) -> {
            autocomplete.addItem(tupa.getProcedimiento());
        });
        autocomplete.setMode(0);
        autocomplete.setCaseSensitive(true);
    }

}
