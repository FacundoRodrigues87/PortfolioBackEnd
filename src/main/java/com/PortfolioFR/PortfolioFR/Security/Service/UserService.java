/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Security.Service;

import com.PortfolioFR.PortfolioFR.Security.Entity.User;
import com.PortfolioFR.PortfolioFR.Security.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    IUserRepository userRepo;
    
    public Optional<User> getByNombreUser(String nombreUser){
        return userRepo.findByNombreUser(nombreUser);
    }
        public boolean existsByNombreUser(String nombreUser){
            return userRepo.existsByNombreUser(nombreUser);
        }
        public boolean existsByEmail(String email){
            return userRepo.existsByEmail(email);
        }
        
        public void save(User user){
            userRepo.save(user);
        }
    }
