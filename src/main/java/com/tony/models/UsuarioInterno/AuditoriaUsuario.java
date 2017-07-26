package com.tony.models.UsuarioInterno;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.tony.models.Documento.OperacionDocumento;
import java.time.Instant;

@Entity
@Table(name = "auditoria_usuario")
public class AuditoriaUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_auditoria;
    
    @Temporal(TemporalType.DATE)
    private Date fecha = Date.from(Instant.now());
    
    @Column(nullable = false)
    private String accion;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "id_operacion_documento", nullable = false)
    private OperacionDocumento operacioDocumento;
    
    public AuditoriaUsuario() {
        
    }
    
    public AuditoriaUsuario(OperacionDocumento operacioDocumento) {
        this.operacioDocumento = operacioDocumento;
    }
    
    public int getId_auditoria() {
        return id_auditoria;
    }
    
    public OperacionDocumento getOperacioDocumento() {
        return operacioDocumento;
    }
    
    public void setOperacioDocumento(OperacionDocumento operacioDocumento) {
        this.operacioDocumento = operacioDocumento;
    }
    
    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getAccion() {
        return accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_auditoria;
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
        final AuditoriaUsuario other = (AuditoriaUsuario) obj;
        if (this.id_auditoria != other.id_auditoria) {
            return false;
        }
        return true;
    }
    
}
