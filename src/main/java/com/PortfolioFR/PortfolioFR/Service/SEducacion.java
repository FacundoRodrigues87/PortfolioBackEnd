/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Service;

import com.PortfolioFR.PortfolioFR.Entitys.Educacion;
import com.PortfolioFR.PortfolioFR.Repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEdu;
    
    public List<Educacion> list(){
        return rEdu.findAll();
    }
    
    public Educacion getOne(int id){
        return rEdu.findById(id).orElse(null);
    }
    
    public Optional<Educacion> getByInstituto(String instituto){
        return rEdu.findByInstituto(instituto);
    }
    
    public void save(Educacion edu){
        rEdu.save(edu);
    }
    
    public void delete(int id){
       rEdu.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEdu.existsById(id);
    }
  
    public boolean existsByInstituto(String instituto){
        return rEdu.existsByInstituto(instituto);
    }
}
