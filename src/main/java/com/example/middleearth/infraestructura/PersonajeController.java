/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.infraestructura;

import com.example.middleearth.aplicacion.PersonajeDTO;
import com.example.middleearth.aplicacion.PersonajeService;
import com.example.middleearth.dominio.Personaje;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class PersonajeController {
    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
    
    @GetMapping("/personajes")
    public List<Personaje> getAllPersonajes(){
        return personajeService.listarHeroes();                
    }
    
    @PostMapping("/generar")
    public Personaje generarPersonaje(@RequestBody PersonajeDTO request) {
       return personajeService.crearHeroe(request.getNombre(), request.getRaza());
    }    
}
