package com.PortfolioFR.PortfolioFR.Security.Controller;

import com.PortfolioFR.PortfolioFR.Security.DTO.JwtDto;
import com.PortfolioFR.PortfolioFR.Security.DTO.LoginUser;
import com.PortfolioFR.PortfolioFR.Security.DTO.NuevoUser;
import com.PortfolioFR.PortfolioFR.Security.Entity.Rol;
import com.PortfolioFR.PortfolioFR.Security.Entity.User;
import com.PortfolioFR.PortfolioFR.Security.Enums.RolNombre;
import com.PortfolioFR.PortfolioFR.Security.Service.RolService;
import com.PortfolioFR.PortfolioFR.Security.Service.UserService;
import com.PortfolioFR.PortfolioFR.Security.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUser nuevoUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) 
            return new ResponseEntity(new Mensaje("Campos mal puestos o email envalido"), HttpStatus.BAD_REQUEST);

            if (userService.existsByNombreUser(nuevoUser.getNombreUser())) 
                return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
            

            if (userService.existsByEmail(nuevoUser.getEmail())) 
                return new ResponseEntity(new Mensaje("Ese Email ya existe"), HttpStatus.BAD_REQUEST);
            

            User usuario = new User(nuevoUser.getNombre(), nuevoUser.getNombreUser(), nuevoUser.getEmail(), passwordEncoder.encode(nuevoUser.getPassword()));

            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

            if (nuevoUser.getRoles().contains("admin")) 
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            usuario.setRoles(roles);
            userService.save(usuario);

            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);

        }
        
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNombreUser(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtProvider.generateToken(auth);
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }

    }

