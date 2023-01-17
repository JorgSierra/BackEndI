package com.dh.clase33.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String titulo;
    @OneToMany(mappedBy = "profesor_mapped", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Estudiante> listEstudiantes = new HashSet<>();

    public Set<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(Set<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
