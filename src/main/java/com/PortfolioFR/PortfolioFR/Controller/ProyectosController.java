package com.PortfolioFR.PortfolioFR.Controller;

import com.PortfolioFR.PortfolioFR.DTO.DtoPro;
import com.PortfolioFR.PortfolioFR.Entitys.Proyectos;
import com.PortfolioFR.PortfolioFR.Security.Controller.Mensaje;
import com.PortfolioFR.PortfolioFR.Service.SProyectos;
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
@RequestMapping("proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired
    SProyectos sPro;
    @Autowired
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sPro.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPro dtopro){
        if(StringUtils.isBlank(dtopro.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sPro.existsByTitle(dtopro.getTitle()))
            return new ResponseEntity(new Mensaje("Esa Proyectos ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos pro = new Proyectos(dtopro.getTitle(), dtopro.getDescripcion(), dtopro.getUrlProyecto(), dtopro.getUrlImagen(), dtopro.getIdUsuario());
        sPro.save(pro);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPro dtopro){
        if(!sPro.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sPro.existsByTitle(dtopro.getTitle()) && sPro.getByTitle(dtopro.getTitle()).get().getidProyecto() != id)
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopro.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        Proyectos pro = sPro.getOne(id);
        pro.setTitle(dtopro.getTitle());
        pro.setDescripcion(dtopro.getDescripcion());
        pro.setUrlImagen(dtopro.getUrlImagen());
        pro.setUrlProyecto(dtopro.getUrlProyecto());
        pro.setIdUsuario(dtopro.getIdUsuario());

        sPro.save(pro);
        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sPro.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sPro.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Proyectos detail(@PathVariable ("id") int id){
        return sPro.getOne(id);
    }
    
    @PutMapping("/edittitle/{id}")
    public void editTitle(@PathVariable int id, @RequestParam("title") String nuevoTitle){
        
        Proyectos pro = sPro.getOne(id);
        pro.setTitle(nuevoTitle);
        sPro.save(pro);
        
    }
    
        @PutMapping("/editdesc/{id}")
    public void editDesc(@PathVariable int id, @RequestParam("descripcion") String nuevaDescripcion){
        
        Proyectos pro = sPro.getOne(id);
        pro.setDescripcion(nuevaDescripcion);
        sPro.save(pro);
        
    }
    
}
