/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Repository;

import com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<ExperienciaLaboral, Integer>{
    public Optional<ExperienciaLaboral> findById(int id);
    public Optional<ExperienciaLaboral> findByEmpresa(String empresa);
    public boolean existsByEmpresa(String empresa);
}
