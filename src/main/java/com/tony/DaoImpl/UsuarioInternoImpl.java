package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_interno;
import com.tony.Dao.hibernateSession;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioInternoImpl implements IUsuario_interno {

    private final hibernateSession hibernate_sesion = hibernateSession.get_instancia_hibernateSession();
    private final Errores error = Errores.get_intancia_error();

    public UsuarioInternoImpl() {

    }

    //Probado y validado
    @Override
    public boolean Registrar_usuario_Externo(UsuarioExterno usuario, Usuario_interno usuario_interno) {
        boolean operacion = false;
        Session se = null;
        try {
            se = this.hibernate_sesion.get_sessionFactor().openSession();
            se.beginTransaction();
            se.persist(usuario);
            se.getTransaction().commit();
            operacion = true;

            // UsuarioExterno usuario_externo = this.get_usuario_externo_find_by_dni(usuario.getDni());
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
            se.close();
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
//            sesionhi = this.hibernatesesion.get_Sesion();
            sesionhi = this.hibernate_sesion.get_sessionFactor().openSession();
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
//        Session sesionhi = this.hibernatesesion.get_Sesion();
        Session sesionhi = this.hibernate_sesion.get_sessionFactor().openSession();
        List<Usuario_interno> user_internos = null;
        try {
            sesionhi.beginTransaction();
            Usuario_interno UsergerenteEntity = sesionhi.find(Usuario_interno.class, Usuario_gerente.getId_persona());
            if (UsergerenteEntity.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Administrador) == 0) {
                user_internos = (List<Usuario_interno>) sesionhi.createCriteria(Usuario_interno.class)
                        .add(Restrictions.not(Restrictions.idEq(Usuario_gerente.getId_persona()))).createAlias("area", "areatotal").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .add(Restrictions.eq("areatotal.tipoArea", UsergerenteEntity.getArea().getTipoArea())).createAlias("perfil", "perfiluser")
                        .setResultTransformer(Criteria.ROOT_ENTITY).add(Restrictions.eq("perfiluser.tipoPerfil", Tipo_Perfil_UsuarioInterno.Profesional))
                        .setFirstResult(inicio).setMaxResults(inicio + 10).list();
            }

            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:All_usuarios_internos" + e.getMessage());

        } finally {
            sesionhi.close();
        }
        return user_internos;
    }

    @Override
    public List<UsuarioExterno> All_usuarios_externos(int Inicio, int Final) {
//        Session sesionhi = this.hibernatesesion.get_Sesion();
        Session sesionhi = this.hibernate_sesion.get_sessionFactor().openSession();
        List<UsuarioExterno> userExterno = null;
        try {
            sesionhi.beginTransaction();
            userExterno = sesionhi.createNamedQuery("UsuarioExterno.all", UsuarioExterno.class).setFirstResult(Inicio).setMaxResults(Final + Inicio).getResultList();
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:All_usuarios_externos" + e.getMessage());
        } finally {
            sesionhi.close();
        }
        return userExterno;
    }
//Falta probar

    private boolean probando_requisitos_usuario_interno(Usuario_interno usuario_interno) {
        Session session = this.hibernate_sesion.get_sessionFactor().openSession();
        boolean valor_privilegios = false;
        try {
            session.beginTransaction();
            Usuario_interno user_interno = (Usuario_interno) session.get(Usuario_interno.class, usuario_interno.getId_persona());
            if (user_interno.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Profesional) == 0 && usuario_interno.getArea().getTipoArea().compareTo(Tipos_Area.pedriatria) == 0) {
                valor_privilegios = true;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(session, "el mensaje viene de UsuarioInternoImpl:probando_requisitos_usuario_interno " + e.getMessage());
        } finally {
            session.close();
        }
        return valor_privilegios;
    }

    //Probado y validado
    @Override
    public boolean add_documento_a_UsuarioExterno(Usuario_interno usuario_interno, UsuarioExterno usuario_externo) {
        Session sesionhi = this.hibernate_sesion.get_sessionFactor().openSession();
        try {
            sesionhi.beginTransaction();
            UsuarioExterno userEntidad = (UsuarioExterno) sesionhi.createNamedQuery("UsuarioExterno.find_by_dni", UsuarioExterno.class).setParameter("dni", usuario_externo.getDni()).uniqueResult();
            userEntidad.getDocumentos().size();
            sesionhi.evict(userEntidad);
            usuario_externo.getDocumentos().stream().forEach((documentos) -> {
                userEntidad.addDocumento(documentos);
//                this.add_operacion_documento_usuario_interno(usuario_interno, documentos);
            });
            sesionhi.merge(userEntidad);
            sesionhi.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesionhi, "error en UsuarioInternoImpl:add_documento_a_UsuarioExterno" + e.getMessage());
        } finally {
            sesionhi.close();
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
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            OperacionDocumento operacion_documento = new OperacionDocumento(usuario_interno, documento);
            sesion.persist(operacion_documento);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "Mensaje de Error de UsuarioInternoImpl:add_operacion_documento_usuario_interno " + e.getMessage());
        } finally {
            sesion.close();
        }
        return false;
    }
//Probado y validad

    @Override
    public UsuarioExterno get_usuario_externo_find_by_dni(int dni) {
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
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

    @Override
    public Usuario_interno get_usuario_interno_by_Dni(int dni) {
        Session session = null;
        Usuario_interno usuarioInterno = new Usuario_interno();
        try {
            session = this.hibernate_sesion.get_sessionFactor().openSession();
            session.beginTransaction();
            Usuario_interno usuarioInterno_temporal = (Usuario_interno) session.createNamedQuery("Usuario_interni.findb_by_dni", Usuario_interno.class).setParameter("dni", dni).uniqueResult();
            usuarioInterno.setPerfil(usuarioInterno_temporal.getPerfil());
            usuarioInterno.setArea(usuarioInterno_temporal.getArea());
            usuarioInterno.setNombre(usuarioInterno_temporal.getNombre());
            usuarioInterno.setId_persona(usuarioInterno_temporal.getId_persona());
            session.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(session, "el  mensaje viene de UsuarioInternoImpl:get_usuario_interno_by_Dni " + e.getMessage());
        } finally {
            session.close();
        }
        return usuarioInterno;

    }

}
