/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IArea;
import com.tony.Dao.hibernateSession;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author antony
 */
public class AreaImpl implements IArea {

    private hibernateSession hibSession = hibernateSession.get_instancia_hibernate_session();
    private Errores erroes = Errores.get_intancia_error();

    @Override
    public List<Area> get_all_area() {
        List<Area> areas = null;
        Session sesion = this.hibSession.AbrirSesion();
        try {
            areas = sesion.createNamedQuery("Area.all", Area.class).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "Error en AreaImpl: get_all_area " + e.getMessage());
        }
        return areas;
    }

    @Override
    public List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
