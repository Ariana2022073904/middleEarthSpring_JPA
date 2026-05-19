/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.aplicacion;

import com.example.middleearth.dominio.Personaje;
import com.example.middleearth.dominio.RazaStrategy;
import com.example.middleearth.infraestructura.CharacterFactory;
import com.example.middleearth.infraestructura.PersonajeJpaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class PersonajeService {
    // Puerto de salida: Inyección por constructor para cumplir con DIP [6, 9]
    private final PersonajeJpaRepository repository;

    public PersonajeService(PersonajeJpaRepository repository) {
        this.repository = repository;
    }

    public Personaje crearHeroe(String nombre, String raza) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("El nombre del héroe es obligatorio.");
        }
        RazaStrategy estrategia = CharacterFactory.getStrategy(raza);
        Personaje nuevoHeroe = new Personaje(nombre, raza, estrategia);
        nuevoHeroe.aplicarBonosRaza();
        repository.save(nuevoHeroe);
     
        System.out.println("Héroe " + nombre + " forjado y guardado correctamente.");
        return nuevoHeroe;
    }

    public List<Personaje> listarHeroes() {
        return repository.findAll();
    }
}
