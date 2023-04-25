/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.DTO;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import jakarta.validation.constraints.NotNull;


public class DtoExp {
    @NotNull
    private String empresa;
    @NotNull
    private String descripcion;
    @NotNull
    private Usuario idUsuario;
    private String url_foto;
    
    public DtoExp() {
    }

    public DtoExp(String empresa, String descripcion, Usuario idUsuario, String url_foto) {
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


    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
