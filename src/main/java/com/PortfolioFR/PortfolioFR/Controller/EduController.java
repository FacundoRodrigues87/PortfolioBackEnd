package com.PortfolioFR.PortfolioFR.Controller;

import com.PortfolioFR.PortfolioFR.DTO.DtoEdu;
import com.PortfolioFR.PortfolioFR.DTO.DtoExp;
import com.PortfolioFR.PortfolioFR.Entitys.Educacion;
import com.PortfolioFR.PortfolioFR.Entitys.ExperienciaLaboral;
import com.PortfolioFR.PortfolioFR.Security.Controller.Mensaje;
import com.PortfolioFR.PortfolioFR.Service.SEducacion;
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
@RequestMapping("educacion")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfoliofacurodrigues.web.app/"})
public class EduController {
    @Autowired
    SEducacion sEdu;
    @Autowired
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEdu.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEdu dtoedu){
        if(StringUtils.isBlank(dtoedu.getInstituto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEdu.existsByInstituto(dtoedu.getInstituto()))
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion edu = new Educacion(dtoedu.getInstituto(), dtoedu.getDescripcion(), dtoedu.getUrl_foto(), dtoedu.getIdUsuario());
        sEdu.save(edu);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEdu dtoedu){
        if(!sEdu.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sEdu.existsByInstituto(dtoedu.getInstituto()) && sEdu.getByInstituto(dtoedu.getInstituto()).get().getIdEducacion() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getInstituto()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        Educacion edu = sEdu.getOne(id);
        edu.setInstituto(dtoedu.getInstituto());
        edu.setDescripcion(dtoedu.getDescripcion());
        edu.setIdUsuario(dtoedu.getIdUsuario());
        
        sEdu.save(edu);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sEdu.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sEdu.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Educacion detail(@PathVariable ("id") int id){
        return sEdu.getOne(id);
    }
    
    @PutMapping("/editinstituto/{id}")
    public void editInstituto(@PathVariable int id, @RequestParam("instituto") String nuevoInstituto){
        
        Educacion edu = sEdu.getOne(id);
        edu.setInstituto(nuevoInstituto);
        sEdu.save(edu);
        
    }
    
        @PutMapping("/editdesc/{id}")
    public void editDesc(@PathVariable int id, @RequestParam("descripcion") String nuevaDescripcion){
        
        Educacion edu = sEdu.getOne(id);
        edu.setDescripcion(nuevaDescripcion);
        sEdu.save(edu);
        
    }
    
}
