/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import jakarta.persistence.Basic;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Facundo
 */
@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEducacion")
    private Integer idEducacion;
    @Column(name = "instituto")
    private String instituto;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idtipo_educacion", referencedColumnName = "idtipo_educacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoEducacion tipoEducacion;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false )
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Educacion() {
    }

    public Educacion(Integer idEducacion ) {
        this.idEducacion  = idEducacion ;
    }

    public Educacion(Integer idEducacion, Usuario idUsuario, TipoEducacion tipoEducacion) {
        this.idEducacion  = idEducacion;
        this.idUsuario = idUsuario;
        this.tipoEducacion = tipoEducacion;
    }

    public Integer getidEducacion() {
        return idEducacion;
    }

    public void setidEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEducacion getTipoEducacion() {
        return tipoEducacion;
    }

    public void setTipoEducacion(TipoEducacion tipoEducacion) {
        this.tipoEducacion = tipoEducacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducacion != null ? idEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educacion)) {
            return false;
        }
        Educacion other = (Educacion) object;
        if ((this.idEducacion == null && other.idEducacion != null) || (this.idEducacion != null && !this.idEducacion.equals(other.idEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PortfolioFR.PortfolioFR.Entitys.Educacion[ educacionPK=" + idEducacion + " ]";
    }
    
}
