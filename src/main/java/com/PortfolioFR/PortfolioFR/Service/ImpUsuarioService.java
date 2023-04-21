/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Service;
import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import org.springframework.stereotype.Service;
import com.PortfolioFR.PortfolioFR.Interface.IUsuarioService;
import com.PortfolioFR.PortfolioFR.Repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ImpUsuarioService implements IUsuarioService {
    @Autowired IUsuarioRepository UserRepo;

    @Override
    public List<Usuario> verUsuarios() {
                List<Usuario> lista = UserRepo.findAll();
                return lista;
    }

    @Override
    public void crearUsuario(Usuario user) {
        UserRepo.save(user);
    }

    @Override
    public void borrarUsuario(Long idUsuario) {
        UserRepo.deleteById(idUsuario);
    }

    @Override
    public Usuario buscarUsuario(Long idUsuario) {
       Usuario user = UserRepo.findById(idUsuario).orElse(null);
        return user;
    }
    
}
