package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Profesor profesor1 = new Profesor();
        Alumno alumno1 = new Alumno();
        Asignatura asignatura1 = new Asignatura();

        System.out.println("1- Instertar un profesor ");
        System.out.println("2- Instertar un alumno ");
        System.out.println("3- Instertar una asignatura ");
        System.out.println("4- Vincular profesor a asignatura ");
        System.out.println("5- Vincular alumno a asignatura ");
        System.out.println("6- Lista profesores ");
        System.out.println("7- Lista alumnos y sus faltas de asistencia ");
        System.out.println("8- Lista asignaturas ");
        System.out.println("9- Lista asignaturas de un profesor ");
        System.out.println("10- Lista asignaturas de un alumno ");
        System.out.println("11- Eliminar un profesor ");
        System.out.println("12- Eliminar un alumno ");
        System.out.println("13- Eliminar una asignatura ");
        System.out.println("14- Modificar un profesor ");
        System.out.println("15- Modificar un alumno ");
        System.out.println("16- Modificar una asignatura ");
        System.out.println("17- Salir ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = br.readLine();
        String nombre = "";
        String id= "";

        switch (opcion) {
            case "1":
                System.out.println("Introduzca el nombre del profesor: ");
                nombre = br.readLine();
                Profesor p = new Profesor();
                p.setNombre(nombre);
                Servicios.insertarProfesor(p);
                break;

            case "2":
                System.out.println("Introduzca el nombre del alumno: ");
                nombre = br.readLine();
                Alumno a = new Alumno();
                a.setNombre(nombre);
                Servicios.insertarAlumno(a);
                break;

            case "3":
                System.out.println("Inserte la asignatura: ");
                nombre = br.readLine();
                Asignatura as = new Asignatura();
                as.setNombre(nombre);
                Servicios.insertarAsignatura(as);
                break;

            case "4":
                System.out.println("Introduzca el id del profesor: ");
                String idProfesor = br.readLine();

                System.out.println("Introduzca el id de la asignatura: ");
                String idAsignatura = br.readLine();

                Servicios.vincularProfesorAsignatura(Integer.parseInt(idProfesor), Integer.parseInt(idAsignatura));
                break;

            case "5":
                System.out.println("Introduzca el id del alumno: ");
                String idAlumno = br.readLine();

                System.out.println("Introduzca el id de la asignatura: ");
                String idAsignatura2 = br.readLine();

                Servicios.vincularAlumnoAsignatura(Integer.parseInt(idAlumno), Integer.parseInt(idAsignatura2));
                break;

            case "6":





        }
    }
}
