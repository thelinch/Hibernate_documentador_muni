package com.tony.DaoImpl;

import com.tony.Dao.IUsuario_interno;
import com.tony.Dao.hibernateSession;
import com.tony.Estados.Estado_documento;
import com.tony.Estados.Tipo_Perfil_UsuarioInterno;
import com.tony.Estados.Tipos_Area;
import com.tony.models.Documento.AuditoriaDocumento;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Estado_documentos;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.Tupa;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import com.tony.models.UsuarioInterno.Area;
import com.tony.models.UsuarioInterno.Usuario_interno;
import java.util.List;
import java.util.stream.Collectors;
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
    public boolean Enviar_area_documento(Documento documento, Usuario_interno user_interno) {
        if (!documento.isDisconforme()) {
            try {
                return this.add_operacion_documento_usuario_interno(user_interno, documento);
            } catch (Exception e) {
                System.out.println("el mensaje viene de UsuarioInterniImpl:Enviar_area_documento " + e.getMessage());
            }
        }
        return false;
    }
//Tenemos que botar todas las areas que tengan ese procedimiento,para que la persona encargada pueda hacer el respectivo envio
//Probado y validado

    public List<Area> get_areas_find_by_tupac_procedimiento(String Procedimiento) {
        Session session = this.hibernate_sesion.get_sessionFactor().openSession();
        List<Area> areas = null;
        try {
            session.beginTransaction();
            areas = session.createNamedQuery("tupac.get_areas_find_by_procedimiento", Tupa.class).setParameter("procedimiento", Procedimiento).uniqueResult().getAreas();
            session.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(session, "EL  mensaje de error viene de UsuarioInternoImpl : get_area_ud_find_by_tupac_procedimiento " + e.getMessage());
        } finally {
            session.close();
        }
        return areas;
    }

    @Override
    public boolean Editar_documento(Documento documento) {
        Session sesionhi = null;
        try {
//            sesionhi = this.hibernatesesion.get_Sesion();
            sesionhi = this.hibernate_sesion.get_sessionFactor().openSession();
            sesionhi.beginTransaction();
            sesionhi.merge(documento);
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
            if (user_interno.getPerfil().getTipoPerfil().compareTo(Tipo_Perfil_UsuarioInterno.Profesional) == 0 && usuario_interno.getArea().getTipoArea().compareTo(Tipos_Area.Tramite_Documentario_y_Archivo_Central) == 0) {
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
            usuario_externo.getDocumentos().forEach((documentos) -> {
//                sesionhi.saveOrUpdate(documentos);
                System.out.println(" asunto documentos " + documentos.getAsunto() + " Foleo " + documentos.getNum_foleo());
            });
            //sesionhi.merge(usuario_externo);
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
//Probado y validad

    @Override
    public UsuarioExterno get_usuario_externo_find_by_dni(int dni) {
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        UsuarioExterno usuario_externo = null;
        try {
            sesion.beginTransaction();
            usuario_externo = (UsuarioExterno) sesion.createNamedQuery("UsuarioExterno.find_by_dni").setParameter("dni", dni).uniqueResult();
            sesion.detach(usuario_externo);
            //usuario_externo.getDocumentos().size();
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
            usuarioInterno.setApellido(usuarioInterno_temporal.getApellido());
            usuarioInterno.setCorreo_electronico(usuarioInterno_temporal.getCorreo_electronico());
            usuarioInterno.setId_persona(usuarioInterno_temporal.getId_persona());
            usuarioInterno.setDni(usuarioInterno_temporal.getDni());
            session.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(session, "el  mensaje viene de UsuarioInternoImpl:get_usuario_interno_by_Dni " + e.getMessage());
        } finally {
            session.close();
        }
        return usuarioInterno;

    }

    @Override
    public List<Documento> get_documents_find_by_Is_Disconforme() {
        List<Documento> documentos = null;
        Session sesion = null;
        try {
            sesion = this.hibernate_sesion.get_sessionFactor().openSession();
            sesion.beginTransaction();
            documentos = sesion.createNamedQuery("Documento.find_by_is_Disconforme", Documento.class).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "El mensaje viene de UsuarioInternoImpl:get_documents_find_by_Is_Disconforme " + e.getMessage());
        } finally {
            sesion.close();
        }
        return documentos;
    }

//Probado y validado
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

    @Override
    public boolean add_operacion_estado_documento_usuario_interno(Documento documento, Enum estado_documento) {
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        Operacion_EstadosDocumentos operacion_estado_documento;
        sesion.beginTransaction();
        try {
            Estado_documentos estado_documento_traido = sesion.createNamedQuery("estado_documentos_find_by_estado_documento", Estado_documentos.class).setParameter("estado", estado_documento).uniqueResult();
            if (estado_documento_traido != null) {
                operacion_estado_documento = new Operacion_EstadosDocumentos(estado_documento_traido, documento);
                sesion.persist(operacion_estado_documento);
                return true;
            }
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "UsuarioInternoImpl:Error en add_operacion_estado_documento_usuario_interno " + e.getMessage());
        } finally {
            sesion.close();
        }

        return true;
    }

    @Override
    public List<AuditoriaDocumento> get_flujograma_documento(int id_documento) {
        List<AuditoriaDocumento> auditoria = null;
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            auditoria = (List<AuditoriaDocumento>) sesion.createCriteria(AuditoriaDocumento.class).createAlias("Operacion_estadoDocumento", "operacion").createAlias("operacion.documento", "documento")
                    .add(Restrictions.eq("documento.id_documento", id_documento)).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "error en DocumentoImpl: get_flujograma_documento " + e.getMessage());
        } finally {
            sesion.close();
        }
        return auditoria;
    }
//Probado y validado

    @Override
    public List<Documento> get_all_documentos_find_by_state(Estado_documento estado_requerido, Tipos_Area area) {
        List<Documento> documentos = null;
        Session sesion = this.hibernate_sesion.get_sessionFactor().openSession();
        try {
            sesion.beginTransaction();
            documentos = (List<Documento>) sesion.createNamedQuery("OperacionDocumento.find_by_area_and_state").setParameter("area", area).list();
            documentos = documentos.stream().filter((documento) -> {
                return documento.getOperacionEstados().get(documento.getOperacionEstados().size() - 1).getEstados().getEstado().compareTo(estado_requerido) == 0;
            }).distinct().collect(Collectors.toList());
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, "El error viene de DocumentoImpl get_all_documentos_find_by_state " + e.getMessage());
        } finally {
            sesion.close();
        }
        return documentos;
    }

    @Override
    public Documento get_document_find_by_id_document(int id_documento) {
        Session sesion = null;
        Documento doc = null;
        try {
            sesion = this.hibernate_sesion.get_sessionFactor().openSession();
            sesion.beginTransaction();
            doc = sesion.find(Documento.class, id_documento);
            sesion.detach(doc);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, " el mensaje viene de UsuarioInternoImpl: get_document_find_by_id_document " + e.getMessage());
        } finally {
            sesion.close();
        }
        return doc;

    }

    @Override
    public Tupa get_tupa_find_by_asunto(String Asunto) {
        Session sesion = null;
        Tupa tupa = null;
        try {
            sesion = this.hibernate_sesion.get_sessionFactor().openSession();
            sesion.beginTransaction();
            tupa = (Tupa) sesion.createNamedQuery("tupac.get_areas_find_by_procedimiento").setParameter("procedimiento", Asunto).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(sesion, " el mensaje viene de UsuarioInternoImpl: get_tupa_find_by_asunto " + e.getMessage());
        } finally {
            sesion.close();
        }
        return tupa;
    }

    @Override
    public List<Area> get_area_find_by_tupa(String nameTupa) {
        Session se = null;
        Tupa tupa = null;
        try {
            se = this.hibernate_sesion.get_sessionFactor().openSession();
            se.beginTransaction();
            tupa = (Tupa) se.createNamedQuery("tupac.get_areas_find_by_procedimiento").setParameter("procedimiento", nameTupa).uniqueResult();
            tupa.getAreas().size();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "El error viene de UsuarioInternoImple:get_area_find_by_tupa " + e.getMessage());
        } finally {
            se.close();
        }
        return tupa.getAreas();
    }

    @Override
    public List<Usuario_interno> get_usuario_interno_find_by_nombre_area(String Area_Nombre) {
        Session se = null;
        Area area = null;
        try {
            se = this.hibernate_sesion.get_sessionFactor().openSession();
            Tipos_Area tipo = Tipos_Area.valueOf(Area_Nombre);
            se.beginTransaction();
            area = (Area) se.createNamedQuery("Area.get_usuarioInterno_find_by_name_area").setParameter("tipo_area", tipo).uniqueResult();
            area.getUsuarioInterno().size();
            se.getTransaction().commit();
        } catch (Exception e) {
            this.error.Manejador_errores(se, "El error viene de UsuarioInternoImple:get_area_find_by_tupa " + e.getMessage());
        } finally {
            se.close();
        }
        return area.getUsuarioInterno();

    }

}
