package com.tony.models.Documento;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AuditoriaDocumento
 *
 */
@Entity
@Table(name = "auditoria_documento")
public class AuditoriaDocumento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_auditoriaDocumento;
    @Column(nullable = true)
    private String EstadoAnterior;
    @Column(nullable = false)
    private String EstadoActual;
    @Temporal(TemporalType.DATE)
    private Date fecha = Date.from(Instant.now());
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(nullable = false, name = "id_estadoOperacionDocumento")
    private Operacion_EstadosDocumentos Operacion_estadoDocumento;
    
    public AuditoriaDocumento() {
        
    }
    
    public AuditoriaDocumento(String EstadoActual, String estado_anterior) {
        this.EstadoActual = EstadoActual;
        this.EstadoAnterior = estado_anterior;
    }
    
    public int getId_auditoriaDocumento() {
        return id_auditoriaDocumento;
    }
    
    public void setId_auditoriaDocumento(int id_auditoriaDocumento) {
        this.id_auditoriaDocumento = id_auditoriaDocumento;
    }
    
    public String getEstadoAnterior() {
        return EstadoAnterior;
    }
    
    public void setEstadoAnterior(String estadoAnterior) {
        EstadoAnterior = estadoAnterior;
    }
    
    public String getEstadoActual() {
        return EstadoActual;
    }
    
    public void setEstadoActual(String estadoActual) {
        EstadoActual = estadoActual;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Operacion_EstadosDocumentos getOperacion_estadoDocumento() {
        return Operacion_estadoDocumento;
    }
    
    public void setOperacion_estadoDocumento(Operacion_EstadosDocumentos operacion_estadoDocumento) {
        Operacion_estadoDocumento = operacion_estadoDocumento;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_auditoriaDocumento;
        return result;
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
        AuditoriaDocumento other = (AuditoriaDocumento) obj;
        if (id_auditoriaDocumento != other.id_auditoriaDocumento) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "AuditoriaDocumento{" + "id_auditoriaDocumento=" + id_auditoriaDocumento + ", EstadoAnterior=" + EstadoAnterior + ", EstadoActual=" + EstadoActual + " fecha " + this.fecha + '}';
    }
    
}
