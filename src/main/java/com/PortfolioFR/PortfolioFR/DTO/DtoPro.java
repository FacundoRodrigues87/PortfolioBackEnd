/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.DTO;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import jakarta.validation.constraints.NotNull;


public class DtoPro {
    @NotNull
    private String title;
    @NotNull
    private String descripcion;
    private String urlProyecto;
    private String urlImagen;
    @NotNull
    private Usuario idUsuario;
    
    public DtoPro() {
    }

    public DtoPro(String title, String descripcion, String urlProyecto, String urlImagen, Usuario idUsuario) {
        this.title = title;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
        this.urlImagen = urlImagen;
        this.idUsuario = idUsuario;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
  
    
}
