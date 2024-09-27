package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Entity
public class Asignatura {
    @Id @GeneratedValue
    private String nombre;

    @ManyToMany
    List<Alumno> alumnos;

    @ManyToOne(cascade = CascadeType.MERGE)
    Profesor profesor;


}
