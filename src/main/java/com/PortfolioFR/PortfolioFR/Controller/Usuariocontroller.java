package com.PortfolioFR.PortfolioFR.Controller;

import com.PortfolioFR.PortfolioFR.Entitys.Usuario;
import com.PortfolioFR.PortfolioFR.Interface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Usuariocontroller {

    @Autowired
    IUsuarioService UserService;

    @GetMapping("/users/list")
    public List<Usuario> getUsers() {
        return UserService.verUsuarios();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/create")
    public ResponseEntity<String> saveUser(@RequestBody Usuario user) {
        UserService.crearUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.borrarUsuario(id);
        return "Usuario eliminado";
    }

    @GetMapping("/user/{id}")
    public Usuario findUser(@PathVariable Long id) {
        return UserService.buscarUsuario(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/edit/{id}")
    public Usuario editUser(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido, @RequestParam("url_foto") String nuevaImg, @RequestParam("acercade") String nuevoAcercade) {
        Usuario user = UserService.buscarUsuario(id);
        user.setNombre(nuevoNombre);
        user.setApellido(nuevoApellido);
        user.setUrlFoto(nuevaImg);
        user.setAcercade(nuevoAcercade);
        UserService.crearUsuario(user);
        return user;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/edit/{id}/acercade")
    public void editAcercaDe(@PathVariable Long id, @RequestParam("acercade") String nuevoAcercade) {
        Usuario user = UserService.buscarUsuario(id);
        user.setAcercade(nuevoAcercade);
        UserService.crearUsuario(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/edit/{id}/nombre")
    public void editNombre(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre) {
        Usuario user = UserService.buscarUsuario(id);
        user.setNombre(nuevoNombre);
        UserService.crearUsuario(user);
    }

    @GetMapping("/user/profile")
    public Usuario getUser() {
        return UserService.buscarUsuario((long) 0);
    }

}
