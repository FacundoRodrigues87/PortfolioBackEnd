/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Repository;

import com.PortfolioFR.PortfolioFR.Entitys.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findById(int id);
    public Optional<Educacion> findByInstituto(String instituto);
    public boolean existsByInstituto(String instituto);
}
