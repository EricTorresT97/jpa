package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Personal {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

}
