package com.dh.clase33.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String puesto;
    @Column
    private Integer numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo_mapped;

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Equipo getEquipo_mapped() {
        return equipo_mapped;
    }

    public void setEquipo_mapped(Equipo equipo_mapped) {
        this.equipo_mapped = equipo_mapped;
    }
}
