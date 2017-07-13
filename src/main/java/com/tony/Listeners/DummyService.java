/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.Listeners;

import com.tony.models.Documento.Documento;
import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.Documento.Operacion_EstadosDocumentos;
import com.tony.models.UsuarioInterno.AuditoriaUsuario;

/**
 *
 * @author antony
 */
public class DummyService {

    public void process(String action, Object entity) {

        if (entity instanceof Documento) {
            Documento doc = (Documento) entity;

            System.out.println("se registro el Operacion_estado_documento:Recepcionado");
        } else if (entity instanceof OperacionDocumento) {
            OperacionDocumento operac = (OperacionDocumento) entity;
            AuditoriaUsuario auditoria_usuario = new AuditoriaUsuario();
            auditoria_usuario.setAccion("registro");
            operac.AddAuditoriaUsuario(auditoria_usuario);
        } else if (entity instanceof Operacion_EstadosDocumentos) {
            Operacion_EstadosDocumentos operacion_estado_documento = (Operacion_EstadosDocumentos) entity;
            
            
        }

    }
}
