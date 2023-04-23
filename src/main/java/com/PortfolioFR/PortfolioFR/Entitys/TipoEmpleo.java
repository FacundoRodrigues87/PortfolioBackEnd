/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "tipo_empleo")

public class TipoEmpleo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTipo de empleo")
    private Integer idTipodeempleo;
    @Column(name = "nombre_tipo")
    private String nombreTipo;

    public TipoEmpleo() {
    }

    public TipoEmpleo(Integer idTipodeempleo) {
        this.idTipodeempleo = idTipodeempleo;
    }


    public Integer getIdTipodeempleo() {
        return idTipodeempleo;
    }

    public void setIdTipodeempleo(Integer idTipodeempleo) {
        this.idTipodeempleo = idTipodeempleo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipodeempleo != null ? idTipodeempleo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpleo)) {
            return false;
        }
        TipoEmpleo other = (TipoEmpleo) object;
        if ((this.idTipodeempleo == null && other.idTipodeempleo != null) || (this.idTipodeempleo != null && !this.idTipodeempleo.equals(other.idTipodeempleo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PortfolioFR.PortfolioFR.Entitys.TipoEmpleo[ idTipodeempleo=" + idTipodeempleo + " ]";
    }
    
}
