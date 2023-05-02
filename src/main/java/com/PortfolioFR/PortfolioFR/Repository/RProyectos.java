/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Repository;

import com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral;
import com.PortfolioFR.PortfolioFR.Entitys.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findById(int id);
    public Optional<Proyectos> findByTitle(String title);
    public boolean existsByTitle(String title);
}
