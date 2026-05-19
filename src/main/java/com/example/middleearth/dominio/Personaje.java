/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.middleearth.dominio;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 *
 * @author USER
 */
@Entity
@Table(name="personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String raza;
    @Embedded
    private Atributos atributos;
    @Transient
    private final RazaStrategy estrategia;
    
    @Override
    public String toString(){
        return getNombre() + " es un " + getRaza() + atributos.toString();
    }
    
    public Personaje(){}
    
    public Personaje(String nombre, String raza, RazaStrategy estrategia) {
        this.nombre = nombre;
        this.raza = raza;
        this.estrategia = estrategia;
        this.atributos = new Atributos();
    }
    
    public void aplicarBonosRaza(){
        if (estrategia != null) {
            estrategia.aplicarBonos(atributos);
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public RazaStrategy getEstrategia() {
        return estrategia;
    }

    public String getHabilidadEspecial() {
        return estrategia != null ? estrategia.getHabilidadEspecial() : "Ninguna";
    }
    
}
