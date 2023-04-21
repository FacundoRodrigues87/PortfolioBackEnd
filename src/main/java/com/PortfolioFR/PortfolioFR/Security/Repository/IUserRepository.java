/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Security.Repository;

import com.PortfolioFR.PortfolioFR.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>  {
    Optional<User> findByNombreUser(String nombreUser);
    
    boolean existsByNombreUser(String nombreUser);
    boolean existsByEmail(String email);
    
}
