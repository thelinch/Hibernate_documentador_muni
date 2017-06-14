/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.DaoImpl.AreaImpl;
import com.tony.ServiceDao.AreaServiceDao;
import com.tony.ServiceDao.LLenar_autocompletar;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;

/**
 *
 * @author antony
 */
public class AreaServiceImpl implements AreaServiceDao, LLenar_autocompletar {

    private AreaImpl areimpl = new AreaImpl();

    @Override
    public List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LLenar_autcompleter(TextAutoCompleter llenar_auto_completar) {
        for (Area area : this.areimpl.get_all_area()) {
            llenar_auto_completar.addItem(area.getTipoArea());
        }
        llenar_auto_completar.setMode(0);
        llenar_auto_completar.setCaseSensitive(true);
    }

}
