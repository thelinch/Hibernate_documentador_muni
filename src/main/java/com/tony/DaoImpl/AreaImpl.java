package com.tony.DaoImpl;

import com.tony.Dao.IArea;
import com.tony.Dao.hibernateSession;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Tupa;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Session;

public class AreaImpl implements IArea {

    private final hibernateSession hibSession;
    private final Errores erroes = Errores.get_intancia_error();
//Probado y validado

    public AreaImpl() {
        this.hibSession = new hibernateSession();
    }

    @Override
    public void create_area(Area area) {
        Session sesion = this.hibSession.get_Sesion();
        try {
            sesion.persist(area);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "error en AreaImpl:create_area " + e.getMessage());
        }

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
        List<Area> areas = null;
        Session sesion = this.hibSession.get_Sesion();
        try {
            areas = sesion.createNamedQuery("Area.all", Area.class).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "Error en AreaImpl: get_all_area " + e.getMessage());
        }
        return areas;
    }
//Probado y validado

    @Override
    public List<Usuario_interno> get_usuarios_interno_find_by_Area_name(String nombre) {
        Session sesion = this.hibSession.get_Sesion();
        List<Usuario_interno> usuario_interno = null;
        try {
            Tipos_Area area_search = Tipos_Area.valueOf(nombre);
            usuario_interno = sesion.createNamedQuery("Area.find_by_name", Area.class).setParameter("name", area_search).uniqueResult().getUsuarioInterno();
            sesion.setFlushMode(FlushMode.COMMIT);
            sesion.flush();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "el error biene de AreaImpl:get_usuarios_interno_find_by_area_name " + e.getMessage());
        }
        return usuario_interno;
    }
//Probado y validado

    @Override
    public List<Tupa> get_tupa_find_by_area_name(String name_area) {
        List<Tupa> list_tupac = null;
        Session sesion = this.hibSession.get_Sesion();
        try {
            Tipos_Area area_searh = Tipos_Area.valueOf(name_area);
            list_tupac = sesion.createNamedQuery("Area.find_by_name", Area.class).setParameter("name", area_searh).uniqueResult().getTupa();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "ele error biene de AreaImpl:get_tupa_find_by_are_name " + e.getMessage());
        } 
        return list_tupac;
    }

    @Override
    public Tupa get_tupa_find_by_name_tupa(String name_tupac) {
        Session sesion = this.hibSession.get_Sesion();
        Tupa tupac_search = null;
        try {
            tupac_search = sesion.createNamedQuery("tupac.find_by_name", Tupa.class).setParameter("procedimiento", name_tupac).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.erroes.Manejador_errores(sesion, "error en AreaImpl:get_tupa_find_by_name_tupa " + e.getMessage());
        }
        return tupac_search;
    }

}
