/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortfolioFR.PortfolioFR.Controller;

import com.PortfolioFR.PortfolioFR.DTO.DtoExp;
import com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral;
import com.PortfolioFR.PortfolioFR.Security.Controller.Mensaje;
import com.PortfolioFR.PortfolioFR.Service.SExperiencia;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpController {
    @Autowired
    SExperiencia sExp;
    @Autowired
    
    
    @GetMapping("/listexp")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = sExp.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/createexp")
    public ResponseEntity<?> create(@RequestBody DtoExp dtoexp){
        if(StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExp.existsByEmpresa(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral exp = new ExperienciaLaboral(dtoexp.getEmpresa(), dtoexp.getDescripcion(), dtoexp.getIdUsuario(), dtoexp.getUrl_foto());
        sExp.save(exp);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/updateexp/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExp dtoexp){
        if(!sExp.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sExp.existsByEmpresa(dtoexp.getEmpresa()) && sExp.getByEmpresa(dtoexp.getEmpresa()).get().getIdExperiencialaboral() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral exp = sExp.getOne(id);
        exp.setEmpresa(dtoexp.getEmpresa());
        exp.setDescripcion(dtoexp.getDescripcion());
        exp.setIdUsuario(dtoexp.getIdUsuario());
        
        sExp.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sExp.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sExp.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ExperienciaLaboral detail(@PathVariable ("id") int id){
        return sExp.getOne(id);
    }
    
    @PutMapping("/editempresa/{id}")
    public void editEmpresa(@PathVariable int id, @RequestParam("empresa") String nuevaEmpresa){
        
        ExperienciaLaboral exp = sExp.getOne(id);
        exp.setEmpresa(nuevaEmpresa);
        sExp.save(exp);
        
    }
    
        @PutMapping("/editdesc/{id}")
    public void editDesc(@PathVariable int id, @RequestParam("descripcion") String nuevaDescripcion){
        
        ExperienciaLaboral exp = sExp.getOne(id);
        exp.setDescripcion(nuevaDescripcion);
        sExp.save(exp);
        
    }
    
}
