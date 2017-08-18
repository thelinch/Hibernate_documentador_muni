/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.tony.DaoImpl.Tipo_documentoImpl;
import com.tony.Estados.Tipos_Documento;
import com.tony.ServiceDao.Tipo_documentoServiceDao;
import com.tony.models.Documento.Documento;
import com.tony.models.Documento.Tipo_Documento;
import com.tony.models.UsuarioExterrno.UsuarioExterno;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;

public class Tipo_documentoServiceImpl implements Tipo_documentoServiceDao {

    Tipo_documentoImpl funciones_tipo_documento = new Tipo_documentoImpl();

    @Override
    public void find_by_name(String name, JLabel receptor_tipo_documento) {
        Tipo_Documento tipo_documento = this.funciones_tipo_documento.get_tipo_documento_find_by_name(name);
        receptor_tipo_documento.setText("El documento es de tipo: " + tipo_documento.getTipoDocumento().toString());
    }

    @Override
    public void LLenar_autcompleter(TextAutoCompleter texto_autocompletado, List<Documento> documentos_user) {
        List<Tipo_Documento> tipo_documentos = this.funciones_tipo_documento.all_tipo_documento();
        if (documentos_user != null && !documentos_user.isEmpty()) {
            tipo_documentos.removeAll(documentos_user.stream().map(Documento::getTipoDocumento).collect(Collectors.toList()));
        }
        tipo_documentos.stream().forEach(tipo -> {
            texto_autocompletado.addItem(tipo.getTipoDocumento().toString());
        });
        texto_autocompletado.setMode(0);
        texto_autocompletado.setCaseSensitive(true);
    }

    @Override
    public List<Tipo_Documento> get_all_tipo_documento_find_by_userExterno(UsuarioExterno user_externo) {
        return this.funciones_tipo_documento.get_all_tipo_documento_find_by_userExterno(user_externo);
    }

    @Override
    public Tipo_Documento get_tipo_documento_find_by_name(String name) {
        return this.funciones_tipo_documento.get_tipo_documento_find_by_name(name);
    }

    @Override
    public List<Documento> all_documento_find_by_id_tipo_documento(int id_tipo_documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
