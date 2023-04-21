/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Interface;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import java.util.List;


public interface IUsuarioService {
    public List<Usuario> verUsuarios();
    public void crearUsuario(Usuario user);
    public void borrarUsuario (Long idUsuario);
    public Usuario buscarUsuario (Long idUsuario);
}
