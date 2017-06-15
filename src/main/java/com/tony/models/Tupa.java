package com.tony.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tupa")
@NamedQueries(
        {
            @NamedQuery(name = "tupac.find_by_name", query = "SELECT a from Tupa a where a.procedimiento=:procedimiento")})
public class Tupa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tupa;
    @Column(nullable = false)
    private String procedimiento;
    @Column(nullable = false)
    private int proceso;
    @Column(nullable = false)
    private int plazo;
//@ManyToOne(fetch=FetchType.LAZY)
//@JoinColumn(name="id_area",nullable=false)
//private Area area;
//    @OneToMany(mappedBy = "tupa", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
//    private List<Documento> documentos;
//    @OneToMany(mappedBy = "tupa", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, targetEntity = Area.class)
//    private List<Area> area;

    public Tupa() {

    }

    public int getId_tupa() {
        return id_tupa;
    }

    public void setId_tupa(int id_tupa) {
        this.id_tupa = id_tupa;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public int getProceso() {
        return proceso;
    }

    public void setProceso(int proceso) {
        this.proceso = proceso;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_tupa;
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
        final Tupa other = (Tupa) obj;
        if (this.id_tupa != other.id_tupa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tupa{" + "id_tupa=" + id_tupa + ", procedimiento=" + procedimiento + ", proceso=" + proceso + ", plazo=" + plazo + '}';
    }

}
