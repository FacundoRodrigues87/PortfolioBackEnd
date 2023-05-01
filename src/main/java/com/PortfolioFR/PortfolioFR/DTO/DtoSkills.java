/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.DTO;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import jakarta.validation.constraints.NotNull;


public class DtoSkills {
    @NotNull
    private String name;
    @NotNull
    private Integer amount;
    @NotNull
    private Usuario idUsuario;
    
    public DtoSkills() {
    }

    public DtoSkills(String name, Integer amount, Usuario idUsuario) {
        this.name = name;
        this.amount = amount;
        this.idUsuario = idUsuario;
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

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
