/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Service;

import com.PortfolioFR.PortfolioFR.Entitys.Proyectos;
import com.PortfolioFR.PortfolioFR.Repository.RProyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rPro;
    
    public List<Proyectos> list(){
        return rPro.findAll();
    }
    
    public Proyectos getOne(int id){
        return rPro.findById(id).orElse(null);
    }
    
    public Optional<Proyectos> getByTitle(String title){
        return rPro.findByTitle(title);
    }
    
    public void save(Proyectos edu){
        rPro.save(edu);
    }
    
    public void delete(int id){
       rPro.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPro.existsById(id);
    }
  
    public boolean existsByTitle(String title){
        return rPro.existsByTitle(title);
    }
}
