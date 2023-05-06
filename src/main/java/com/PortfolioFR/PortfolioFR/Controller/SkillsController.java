package com.PortfolioFR.PortfolioFR.Controller;

import com.PortfolioFR.PortfolioFR.DTO.DtoSkills;
import com.PortfolioFR.PortfolioFR.Entitys.Skills;
import com.PortfolioFR.PortfolioFR.Security.Controller.Mensaje;
import com.PortfolioFR.PortfolioFR.Service.SSkills;
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
@RequestMapping("skills")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfoliofacurodrigues.web.app/"})
public class SkillsController {
    @Autowired
    SSkills sSkills;
    @Autowired
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoskill){
        if(StringUtils.isBlank(dtoskill.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByName(dtoskill.getName()))
            return new ResponseEntity(new Mensaje("Esa Skills ya existe"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getAmount()>100)
        return new ResponseEntity(new Mensaje("El amount no puede ser mayor a 100"), HttpStatus.BAD_REQUEST);    
        
        Skills skill = new Skills(dtoskill.getName(), dtoskill.getAmount(), dtoskill.getIdUsuario());
        sSkills.save(skill);
        
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoskill){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sSkills.existsByName(dtoskill.getName()) && sSkills.getByName(dtoskill.getName()).get().getidSkill() != id)
            return new ResponseEntity(new Mensaje("Esa Skills ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getName()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        Skills skill = sSkills.getOne(id);
        skill.setName(dtoskill.getName());
        skill.setAmount(dtoskill.getAmount());
        skill.setidUsuario(dtoskill.getIdUsuario());
        
        sSkills.save(skill);
        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sSkills.delete(id);
        
        return new ResponseEntity(new Mensaje("Skills eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Skills detail(@PathVariable ("id") int id){
        return sSkills.getOne(id);
    }
    
    @PutMapping("/editname/{id}")
    public void editName(@PathVariable int id, @RequestParam("name") String nuevoName){
        
        Skills skill = sSkills.getOne(id);
        skill.setName(nuevoName);
        sSkills.save(skill);
        
    }
    
        @PutMapping("/editamount/{id}")
    public ResponseEntity<?> editDesc(@PathVariable int id, DtoSkills dtoskill, @RequestParam("amount") Integer nuevoAmount){
        if(dtoskill.getAmount()>100)
        return new ResponseEntity(new Mensaje("El amount no puede ser mayor a 100"), HttpStatus.BAD_REQUEST);  
                
        Skills skill = sSkills.getOne(id);
        skill.setAmount(nuevoAmount);
        sSkills.save(skill);
        return new ResponseEntity(new Mensaje("Amount editado"), HttpStatus.OK);
        
    }
    
}
