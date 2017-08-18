package com.tony.models.Documento;

import com.tony.Estados.Tipos_Documento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tipo_documento")
@NamedQueries({
    @NamedQuery(name = "tipo_documento.all", query = "SELECT a from Tipo_Documento a"),
    @NamedQuery(name = "tipo_documento.find_by_name", query = "SELECT a FROM Tipo_Documento a where a.TipoDocumento= :nombre")
})
public class Tipo_Documento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_documento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TipoDocumento")
    private Tipos_Documento TipoDocumento;
    @OneToMany(mappedBy = "tipoDocumento", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Documento> documentos = new ArrayList<>();
    
    public Tipo_Documento() {
    }

    public void addDocumento(Documento documento) {
        if (this.documentos.isEmpty() || !this.documentos.contains(documento)) {
            this.documentos.add(documento);
            documento.setTipoDocumento(this);
        }
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }
    
    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }
    
    public List<Documento> getDocumentos() {
        return documentos;
    }
    
    public com.tony.Estados.Tipos_Documento getTipoDocumento() {
        return TipoDocumento;
    }
    
    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
    
    public void setTipoDocumento(Tipos_Documento tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_tipo_documento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tipo_Documento other = (Tipo_Documento) obj;
        if (this.id_tipo_documento != other.id_tipo_documento) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Tipo_Documento [id_tipo_documento=" + id_tipo_documento + ", TipoDocumento=" + TipoDocumento + "]";
    }
    
}
