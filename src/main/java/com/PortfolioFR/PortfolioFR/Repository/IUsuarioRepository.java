package com.PortfolioFR.PortfolioFR.Repository;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
