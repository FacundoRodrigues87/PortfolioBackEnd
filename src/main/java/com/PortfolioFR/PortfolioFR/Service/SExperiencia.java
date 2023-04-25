/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Service;

import com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral;
import com.PortfolioFR.PortfolioFR.Repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExp;
    
    public List<ExperienciaLaboral> list(){
        return rExp.findAll();
    }
    
    public ExperienciaLaboral getOne(int id){
        return rExp.findById(id).orElse(null);
    }
    
    public Optional<ExperienciaLaboral> getByEmpresa(String empresa){
        return rExp.findByEmpresa(empresa);
    }
    
    public void save(ExperienciaLaboral exp){
        rExp.save(exp);
    }
    
    public void delete(int id){
       rExp.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExp.existsById(id);
    }
  
    public boolean existsByEmpresa(String empresa){
        return rExp.existsByEmpresa(empresa);
    }
}
