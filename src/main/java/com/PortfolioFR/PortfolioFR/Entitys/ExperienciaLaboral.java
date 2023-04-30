/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Facundo
 */
@Entity
@Table(name = "experiencia_laboral")
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_experiencialaboral")
    private Integer idExperiencialaboral;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column (name = "url_foto")
    private String url_foto;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"apellido", "correo", "acercade", "urlFoto", "skillsList", "experienciaLaboralList", "educacionList", "proyectosList"})
    private Usuario idUsuario;

    
    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String empresa, String descripcion, Usuario idUsuario, String url_foto) {
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.url_foto = url_foto;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdExperiencialaboral() {
        return idExperiencialaboral;
    }

    public void setIdExperiencialaboral(Integer idExperiencialaboral) {
        this.idExperiencialaboral = idExperiencialaboral;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario usuarioidUsuario) {
        this.idUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperiencialaboral != null ? idExperiencialaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.idExperiencialaboral == null && other.idExperiencialaboral != null) || (this.idExperiencialaboral != null && !this.idExperiencialaboral.equals(other.idExperiencialaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral[ idExperiencialaboral=" + idExperiencialaboral + " ]";
    }
    
}
