package com.dh.clase33.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String ciudad;
    @OneToMany(mappedBy = "equipo_mapped", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Jugador> listJugadores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<Jugador> getListJugadores() {
        return listJugadores;
    }

    public void setListJugadores(Set<Jugador> listJugadores) {
        this.listJugadores = listJugadores;
    }
}
