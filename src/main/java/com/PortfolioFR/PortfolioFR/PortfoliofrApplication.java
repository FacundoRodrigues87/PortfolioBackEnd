package com.PortfolioFR.PortfolioFR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.PortfolioFR.PortfolioFR") 
public class PortfoliofrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfoliofrApplication.class, args);
                
	}

}
