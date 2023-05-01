/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import jakarta.persistence.Basic;
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
@Table(name = "skills")

public class Skills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idskills")
    private Integer idSkill;
    @Column(name = " name")
    private String name;
    @Column(name = "amount")
    private Integer amount;
   @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"apellido", "correo", "acercade", "urlFoto", "skillsList", "experienciaLaboralList", "educacionList", "proyectosList"})
    private Usuario idUsuario;

    public Skills() {
    }

    public Skills(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Skills(String name, Integer amount, Usuario idUsuario) {
        this.name = name;
        this.amount = amount;
        this.idUsuario = idUsuario;
    }

    


    public Integer getidSkill() {
        return idSkill;
    }

    public void setidSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public String setAmount(Integer amount) {
        if(amount>100){
            return "El valor no puede ser mayor que 100";
        }else{
        this.amount = amount;
        return "Amount set";
        }
    }

    public Usuario getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(Usuario usuarioIdUsuario) {
        this.idUsuario = usuarioIdUsuario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkill != null ? idSkill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skills)) {
            return false;
        }
        Skills other = (Skills) object;
        if ((this.idSkill == null && other.idSkill != null) || (this.idSkill != null && !this.idSkill.equals(other.idSkill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.PortfolioFR.PortfolioFR.Entitys.Skills[ skillsPK=" + idSkill + " ]";
    }
    
}
