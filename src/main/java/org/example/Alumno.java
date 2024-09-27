package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Entity
@PrimaryKeyJoinColumn(name="personalId")
public class Alumno extends Personal{
    private int faltasAsistencia;

    @ManyToMany
    List<Asignatura> asignaturas;
}
