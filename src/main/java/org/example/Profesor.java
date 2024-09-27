package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Entity
@PrimaryKeyJoinColumn (name="personalId")
public class Profesor extends Personal{


    @OneToMany (mappedBy = "profesor", orphanRemoval = true, fetch = FetchType.EAGER)
    private List <Asignatura> asignaturas;
}
