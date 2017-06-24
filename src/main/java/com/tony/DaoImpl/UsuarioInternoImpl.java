package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_interno;
import com.tony.Dao.hibernateSession;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioInternoImpl implements IUsuario_interno {

    private final hibernateSession hibernatesesion;
    private final Errores error = Errores.get_intancia_error();

    public UsuarioInternoImpl() {
        this.hibernatesesion = new hibernateSession();
    }

    //Falta Probar
    @Override
    public boolean Registrar_usuario_Externo(UsuarioExterno usuario, Usuario_interno usuario_interno) {
        boolean operacion = false;
        Session se = null;
        try {
            se = this.hibernatesesion.get_Sesion();

            // UsuarioExterno usuario_externo = this.get_usuario_externo_find_by_dni(usuario.getDni());
            se.beginTransaction();
            se.persist(usuario);
            se.getTransaction().commit();
            operacion = true;
//            operacion = true;
//            } else {
//
//                usuario.getDocumentos().stream().forEach((documento) -> {
//                    usuario_externo.addDocumento(documento);
//                });
//            }
        } catch (Exception e) {
            this.error.Manejador_errores(se, "error en UsuarioInternoImpl:Resgistrar_usuario_externo" + e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }

        }
//        if (!usuario.getDocumentos().isEmpty()) {
//            usuario.getDocumentos().stream().map((documento) -> {
//                this.add_operacion_documento_usuario_interno(usuario_interno, documento);
//                return documento;
//            }).forEach((documento) -> {
//                this.Enviar_area_documento(documento);
//            });
//        }
        return operacion;
    }

    @Override
    public boolean Enviar_area_documento(Documento documento) {
        if (!documento.isDisconforme()) {

        }
        return true;
    }

    @Override
    public boolean Editar_documento(Documento documento) {
        Session sesionhi = null;
        try {
            sesionhi = this.hibernatesesion.get_Sesion();
            sesionhi.beginTransaction();
            sesionhi.update(documento);
            sesionhi.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:Editar_documento" + e.getMessage());
        } finally {
            sesionhi.close();
        }
        return false;
    }

    @Override
    public List<Usuario_interno> All_usuarios_internos(Usuario_interno Usuario_gerente, int inicio) {
        Session sesionhi = this.hibernatesesion.get_Sesion();
        List<Usuario_interno> user_internos = null;
        try {
            sesionhi.beginTransaction();
            Usuario_interno UsergerenteEntity = sesionhi.find(Usuario_interno.class, Usuario_gerente.getId_persona());
            if (UsergerenteEntity.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Administrador) == 0) {
                user_internos = (List<Usuario_interno>) sesionhi.createCriteria(Usuario_interno.class)
                        .add(Restrictions.not(Restrictions.idEq(Usuario_gerente.getId_persona()))).createAlias("area", "areatotal").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .add(Restrictions.eq("areatotal.tipoArea", UsergerenteEntity.getArea().getTipoArea())).createAlias("perfil", "perfiluser").setResultTransformer(Criteria.ROOT_ENTITY).add(Restrictions.eq("perfiluser.tipoPerfil", Tipo_Perfil_UsuarioInterno.Profesional))
                        .setFirstResult(inicio).setMaxResults(inicio + 10).list();
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
        Session sesionhi = this.hibernatesesion.get_Sesion();
        List<UsuarioExterno> userExterno = null;
        try {
            sesionhi.beginTransaction();
            userExterno = sesionhi.createNamedQuery("UsuarioExterno.all", UsuarioExterno.class).setFirstResult(Inicio).setMaxResults(Final + Inicio).getResultList();
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:All_usuarios_externos" + e.getMessage());
        }
        return userExterno;
    }

    @Override
    public boolean add_documento_a_UsuarioExterno(Documento documento, Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        Session sesionhi = this.hibernatesesion.get_Sesion();
        try {
            sesionhi.beginTransaction();
            UsuarioExterno userEntidad = sesionhi.find(UsuarioExterno.class, usuario_externo.getId_persona());
            userEntidad.getDocumentos().size();
            userEntidad.addDocumento(documento);
            sesionhi.getTransaction().commit();
            this.add_operacion_documento_usuario_interno(usuario_interno, documento);
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:add_documentoUsuarioExterno" + e.getMessage());
        }
        return true;
    }
//Falta probar este metodo

    @Override
    public boolean Derivar_documento(Usuario_interno usuario_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//Probar este metodo

    @Override
    public boolean add_operacion_documento_usuario_interno(Usuario_interno usuario_interno, Documento documento) {
        Session sesion = this.hibernatesesion.get_Sesion();
        try {
            OperacionDocumento operacion_documento = new OperacionDocumento(usuario_interno, documento);
            sesion.persist(operacion_documento);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Mensaje de Error de UsuarioInternoImpl:add_operacion_documento_usuario_interno " + e.getMessage());
        }
        return false;
    }
//Probado y validad

    @Override
    public UsuarioExterno get_usuario_externo_find_by_dni(int dni) {
        Session sesion = this.hibernatesesion.get_Sesion();
        UsuarioExterno usuario_externo = null;
        try {
            sesion.beginTransaction();
            usuario_externo = (UsuarioExterno) sesion.createNamedQuery("UsuarioExterno.find_by_dni").setParameter("dni", dni).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Error en UsuarioInternoImpl : get_usuario_externo_find_by_dni " + e.getMessage());
        } finally {
            sesion.close();
        }
        return usuario_externo;
    }

    @Override
    public boolean Registrar_usuario_interno(Usuario_interno user_interno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
