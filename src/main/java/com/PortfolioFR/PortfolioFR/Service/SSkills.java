/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Service;

import com.PortfolioFR.PortfolioFR.Entitys.Educacion;
import com.PortfolioFR.PortfolioFR.Entitys.Skills;
import com.PortfolioFR.PortfolioFR.Repository.RSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkill;
    
    public List<Skills> list(){
        return rSkill.findAll();
    }
    
    public Skills getOne(int id){
        return rSkill.findById(id).orElse(null);
    }
    
    public Optional<Skills> getByName(String name){
        return rSkill.findByName(name);
    }
    
    public void save(Skills edu){
        rSkill.save(edu);
    }
    
    public void delete(int id){
       rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
  
    public boolean existsByName(String name){
        return rSkill.existsByName(name);
    }
}
