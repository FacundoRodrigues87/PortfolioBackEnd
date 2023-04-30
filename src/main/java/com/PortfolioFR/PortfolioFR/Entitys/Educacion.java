/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
     @Column (name = "url_foto")
    private String url_foto;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"apellido", "correo", "acercade", "urlFoto", "skillsList", "experienciaLaboralList", "educacionList", "proyectosList"})
    private Usuario idUsuario;

    public Educacion() {
    }

    public Educacion(String instituto, String descripcion, String url_foto, Usuario idUsuario) {
        this.instituto = instituto;
        this.descripcion = descripcion;
        this.url_foto = url_foto;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
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
