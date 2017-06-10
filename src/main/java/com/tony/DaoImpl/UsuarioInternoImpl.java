/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_interno;
import com.tony.Dao.hibernateSession;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.OperacionDocumento;

import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import javax.persistence.FlushModeType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
public class UsuarioInternoImpl implements IUsuario_interno {
    private final hibernateSession hibernatesesion = hibernateSession.get_instancia_hibernate_session();
    private final Errores error = Errores.get_intancia_error();
    @Override
    public boolean Registrar_usuario_Externo(UsuarioExterno usuario) {
        boolean operacion = false;
        Session se = this.hibernatesesion.AbrirSesion();
        try {
            se.persist(usuario);
            se.getTransaction().commit();
            operacion = true;
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en UsuarioInternoImpl:Resgistrar_usuario_externo" + e.getMessage());
        }
        return operacion;
    }
    

    @Override
    public boolean Registrar_documento(Usuario_interno usuarioInterno, Documento documento, UsuarioExterno usuarioExterno) {
        boolean proceso = false;

//Falta ver el tipo de Documento como va a ser por id o por el nombre
        Session sesionhi =this.hibernatesesion.AbrirSesion();
        try {
            OperacionDocumento operacion = new OperacionDocumento(usuarioInterno, documento);
            usuarioInterno.AddOperacionDocumento(operacion);
            sesionhi.persist(usuarioInterno);
            sesionhi.persist(usuarioExterno);
            sesionhi.setFlushMode(FlushModeType.COMMIT);
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:Registrar_documento" + e.getMessage());

        }
        return proceso;

    }

    @Override
    public boolean Enviar_area_documento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Editar_documento(Documento documento) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        try {
            sesionhi.update(documento);
            sesionhi.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:Editar_documento" + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente, int inicio, int Final) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        List<Usuario_interno> user_internos = null;
        try {
            sesionhi.getTransaction().begin();
            Usuario_interno UsergerenteEntity = sesionhi.find(Usuario_interno.class, Usuario_gerente.getId_persona());
            if (UsergerenteEntity.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Administrador) == 0) {
                user_internos = (List<Usuario_interno>) sesionhi.createCriteria(Usuario_interno.class)
                        .add(Restrictions.not(Restrictions.idEq(Usuario_gerente.getId_persona()))).createAlias("area", "areatotal").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .add(Restrictions.eq("areatotal.tipoArea", UsergerenteEntity.getArea().getTipoArea())).createAlias("perfil", "perfiluser").setResultTransformer(Criteria.ROOT_ENTITY).add(Restrictions.eq("perfiluser.tipoPerfil", Tipo_Perfil_UsuarioInterno.Profesional))
                        .setFirstResult(inicio).list();
            }

            sesionhi.getTransaction().commit();
            System.out.println(user_internos);
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:All_usuarios_internos" + e.getMessage());

        }
        return user_internos;
    }

    @Override
    public List<UsuarioExterno> All_usuarios_externos(int Inicio, int Final) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        List<UsuarioExterno> userExterno = null;
        try {
            userExterno = sesionhi.createNamedQuery("UsuarioExterno.all", UsuarioExterno.class).setFirstResult(Inicio).setMaxResults(Final + Inicio).getResultList();
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:All_usuarios_externos" + e.getMessage());
        }
        return userExterno;
    }

    @Override
    public boolean add_documentoUsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        Session sesionhi = this.hibernatesesion.AbrirSesion();
        try {
            UsuarioExterno userEntidad = sesionhi.find(UsuarioExterno.class, usuario_externo.getId_persona());
            userEntidad.addDocumento(documento);
            OperacionDocumento oper = new OperacionDocumento(usuario_interno, documento);
            usuario_interno.AddOperacionDocumento(oper);
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:add_documentoUsuarioExterno" + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean Derivar_documento(Usuario_interno usuario_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
