/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Facundo
 */
@Entity
@Table(name = "tipo_educacion")

public class TipoEducacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipo_educacion")
    private Integer idtipoEducacion;
    @Column(name = "tipo_educacion")
    private String tipoEducacion;

    public TipoEducacion() {
    }

    public TipoEducacion(Integer idtipoEducacion) {
        this.idtipoEducacion = idtipoEducacion;
    }

    public Integer getIdtipoEducacion() {
        return idtipoEducacion;
    }

    public void setIdtipoEducacion(Integer idtipoEducacion) {
        this.idtipoEducacion = idtipoEducacion;
    }

    public String getTipoEducacion() {
        return tipoEducacion;
    }

    public void setTipoEducacion(String tipoEducacion) {
        this.tipoEducacion = tipoEducacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEducacion != null ? idtipoEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEducacion)) {
            return false;
        }
        TipoEducacion other = (TipoEducacion) object;
        if ((this.idtipoEducacion == null && other.idtipoEducacion != null) || (this.idtipoEducacion != null && !this.idtipoEducacion.equals(other.idtipoEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PortfolioFR.PortfolioFR.Entitys.TipoEducacion[ idtipoEducacion=" + idtipoEducacion + " ]";
    }
    
}
