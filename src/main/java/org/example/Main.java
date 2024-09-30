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
        boolean x = false;
        while (!x) {

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
            String id = "";

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
                    Servicios.listaProfesores();
                    System.out.println("Introduzca el id del profesor: ");
                    String idProfesor = br.readLine();

                    Servicios.listaAsignatura();
                    System.out.println("Introduzca el id de la asignatura: ");
                    String idAsignatura = br.readLine();

                    Servicios.vincularProfesorAsignatura(Integer.parseInt(idProfesor), Integer.parseInt(idAsignatura));
                    break;

                case "5":
                    Servicios.listaAlumno();
                    System.out.println("Introduzca el id del alumno: ");
                    String idAlumno = br.readLine();
                    Servicios.listaAsignatura();
                    System.out.println("Introduzca el id de la asignatura: ");
                    String idAsignatura2 = br.readLine();

                    Servicios.vincularAlumnoAsignatura(Integer.parseInt(idAlumno), Integer.parseInt(idAsignatura2));
                    break;

                case "6":
                    System.out.println("Estos son los profesores registrados: ");
                    List<Profesor> profesores = Servicios.listaProfesores();
                    if (profesores.isEmpty()) {
                        System.out.println("No hay profesores registrados.");
                    } else {
                        for (Profesor profesor : profesores) {
                            System.out.println("ID: " + profesor.getId() + " - Nombre: " + profesor.getNombre());
                        }
                    }
                    break;
                case "7":
                    System.out.println("Estos son los alumnos y sus faltas de asistencia: ");
                    List<Alumno> alumnos = Servicios.listaAlumno();
                    if (alumnos.isEmpty()) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        for (Alumno alumno : alumnos) {
                            System.out.println("ID: " + alumno.getId() + " -Nombre: " + alumno.getNombre()
                                    + " -Faltas de asistencias: " + alumno.getFaltasAsistencia());
                        }
                    }
                case "8":
                    System.out.println("Estas son las asignaturas: ");
                    List<Asignatura> asignaturas = Servicios.listaAsignatura();
                    if (asignaturas.isEmpty()) {
                        System.out.println("No hay asignaturas registradas. ");
                    } else {
                        for (Asignatura asignatura : asignaturas) {
                            System.out.println("Asignatura: " + asignatura.getNombre());
                        }
                    }
                case "9":
                    System.out.println("Introduce el id del profesor: ");
                    String idProfesorAs = br.readLine();
                    int idProfesor3 = Integer.parseInt(idProfesorAs);

                    List<Asignatura> asignaturasProfesor = Servicios.obtenerAsignaturaDeProfesor(idProfesor3);

                    if (asignaturasProfesor == null) {
                        System.out.println("El profesor con ID: " + idProfesor3 + " no existe ");
                    } else if (asignaturasProfesor.isEmpty()) {
                        System.out.println("El profesor con ID " + idProfesor3 + " no tiene asignaturas asignadas ");
                    } else {
                        System.out.println("Asignaturas del profesor con ID: " + idProfesor3 + ":");
                        for (Asignatura asignatura : asignaturasProfesor) {
                            System.out.println("ID: " + asignatura.getId() + " Nombre: " + asignatura.getNombre());
                        }
                    }
                    break;

                case "10":
                    System.out.println("Introduce el id del alumno: ");
                    String idAlumnoAs = br.readLine();
                    int idAlumno3 = Integer.parseInt(idAlumnoAs);
                    List<Asignatura> asignaturasAlumno = Servicios.obtenerAsignaturaDeAlumno(idAlumno3);

                    if (asignaturasAlumno == null) {
                        System.out.println("El alumno con ID: " + idAlumno3 + " no existe ");
                    } else if (asignaturasAlumno.isEmpty()) {
                        System.out.println("El alumno con ID " + idAlumno3 + " no tiene asignaturas asignadas ");
                    } else {
                        System.out.println("Asignaturas del alumno con ID: " + idAlumno3 + ":");
                        for (Asignatura asignatura : asignaturasAlumno) {
                            System.out.println("ID: " + asignatura.getId() + " Nombre: " + asignatura.getNombre());
                        }
                    }
                case "11":
                    System.out.println("Introduce el ID del profesor que desea eliminar: ");
                    String idProfesorBorrarStr = br.readLine();
                    int idProfesorBorrarInt = Integer.parseInt(idProfesorBorrarStr);

                    Servicios.eliminarProfesor(idProfesorBorrarInt);
                    System.out.println("El profesor con ID: " + idProfesorBorrarInt + " ha sido eliminado");
                    break;
                case "12":
                    System.out.println("Introduce el ID del alumno que desea eliminar: ");
                    String idAlumnoBorrarStr = br.readLine();
                    int idAlumnoBorrarInt = Integer.parseInt(idAlumnoBorrarStr);
                    Servicios.eliminarAlumno(idAlumnoBorrarInt);
                    System.out.println("El alumno con ID: " + idAlumnoBorrarInt + " ha sido eliminado");
                    break;
                case "13":
                    System.out.println("Introduce el ID de la asignatura que desea eliminar: ");
                    String idAsignaturaBorrarStr = br.readLine();
                    int idAsignaturaBorrarInt = Integer.parseInt(idAsignaturaBorrarStr);
                    Servicios.eliminarAsignatura(idAsignaturaBorrarInt);
                    System.out.println("La asignatura con ID: " + idAsignaturaBorrarInt + " ha sido eliminada ");
                    break;
                case "14":
                    System.out.println("Introduce el ID del profesor que quiere modificar: ");
                    String idProfesorModiStr = br.readLine();
                    int idProfesorModiInt = Integer.parseInt(idProfesorModiStr);

                    System.out.println("Introduce el nuevo nombre del profesor: ");
                    String nuevoNombreProfe = br.readLine();
                    Servicios.modificarProfesor(idProfesorModiInt, nuevoNombreProfe);
                    break;
                case "15":
                    System.out.println("Introduce el ID del alumno que quiere modificar: ");
                    String idAlumnoModiStr = br.readLine();
                    int idAlumnoModiInt = Integer.parseInt(idAlumnoModiStr);

                    System.out.println("Introduce el nuevo nombre del alumno: ");
                    String nuevoNombreAlumno = br.readLine();
                    Servicios.modificarAlumno(idAlumnoModiInt, nuevoNombreAlumno);
                    break;
                case "16":
                    System.out.println("Introduce el ID de la asignatura que quiere modificar: ");
                    String idAsignaturaModiStr = br.readLine();
                    int idAsignaturaModiInt = Integer.parseInt(idAsignaturaModiStr);

                    System.out.println("Introduce el nuevo nombre de la asignatura: ");
                    String nuevoNombreAsignatura = br.readLine();
                    Servicios.modificarAsignatura(idAsignaturaModiInt, nuevoNombreAsignatura);
                    break;
                case "17":
                    System.out.println("Saliendo de la aplicacion...");
                    x = true;
                    break;

            }
        }


    }
}

