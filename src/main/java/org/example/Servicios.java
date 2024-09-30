package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Servicios {

    public static void insertarProfesor(Profesor p){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertarAlumno(Alumno a){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertarAsignatura(Asignatura as){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();
        em.persist(as);
        em.getTransaction().commit();
        em.close();
    }

    public static void vincularProfesorAsignatura (int idProfesor, int idAsignatura){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Profesor profesor = em.find(Profesor.class, idProfesor);
        Asignatura asignatura = em.find(Asignatura.class, idAsignatura);
        profesor.getAsignaturas().add(asignatura);
        asignatura.setProfesor(profesor);
        em.getTransaction().begin();
        em.merge(profesor);
        em.merge(asignatura);
        em.getTransaction().commit();
        em.close();
    }

    public static void vincularAlumnoAsignatura (int idAlumno, int idAsignatura){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Alumno alumno = em.find(Alumno.class, idAlumno);
        Asignatura asignatura = em.find(Asignatura.class, idAsignatura);
        alumno.getAsignaturas().add(asignatura);
        asignatura.getAlumnos().add(alumno);
        em.getTransaction().begin();
        em.merge(alumno);
        em.merge(asignatura);
        em.getTransaction().commit();
        em.close();

    }

    public static List<Profesor> listaProfesores(){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        TypedQuery<Profesor> query = em.createQuery("SELECT p from Profesor p", Profesor.class);
        List<Profesor> profesores =query.getResultList();
        for (Profesor profesor : profesores){
            System.out.println("ID: " + profesor.getId() + " PROFESOR: " + profesor.getNombre());
        }
        em.close();
        return profesores;
    }
    public static List<Alumno> listaAlumno(){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        TypedQuery<Alumno> query = em.createQuery("SELECT a from Alumno a", Alumno.class);
        List<Alumno> alumnos =query.getResultList();
        for (Alumno alumno : alumnos){
            System.out.println("ID: "+ alumno.getId()+ "ALUMNO: " + alumno.getNombre());
        }
        em.close();
        return alumnos;
}
    public static List<Asignatura> listaAsignatura(){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        TypedQuery<Asignatura> query = em.createQuery("SELECT a from Asignatura a", Asignatura.class);
        List<Asignatura> asignaturas =query.getResultList();
        for (Asignatura asignatura : asignaturas){
            System.out.println("ID: " + asignatura.getId()+ "ASIGNATURA: " + asignatura.getNombre());
        }
        em.close();
        return asignaturas;
}
public static List<Asignatura> obtenerAsignaturaDeProfesor(int idProfesor){
    EntityManager em = EntityManagerSingleton.getEntityManager();
    Profesor profesor = em.find(Profesor.class, idProfesor);
    if (profesor != null){
        return profesor.getAsignaturas();
    }else {
        return null;
    }

}
    public static List<Asignatura> obtenerAsignaturaDeAlumno(int idAlumno){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Alumno alumno = em.find(Alumno.class, idAlumno);
        if (alumno != null){
            return alumno.getAsignaturas();
        }else {
            return null;
        }
}
public static void eliminarProfesor(int idProfesor){
    EntityManager em = EntityManagerSingleton.getEntityManager();
    Profesor profesor = em.find(Profesor.class, idProfesor);
    if (profesor != null) {
        em.getTransaction().begin();
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            asignatura.setProfesor(null);
            em.merge(asignatura);
        }
        em.remove(profesor);
        em.getTransaction().commit();
    } else {
        System.out.println("El profesor con ID " + idProfesor + " no existe.");
    }

    em.close();
}
    public static void eliminarAlumno(int idAlumno){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Alumno alumno = em.find(Alumno.class, idAlumno);
        if (alumno != null) {
            em.getTransaction().begin();
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                asignatura.setProfesor(null);
                em.merge(asignatura);
            }
            em.remove(alumno);
            em.getTransaction().commit();
        } else {
            System.out.println("El alumno con ID " + idAlumno + " no existe.");
        }

        em.close();
    }

    public static void eliminarAsignatura(int idAsignatura){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Asignatura asignatura = em.find(Asignatura.class, idAsignatura);
        if (asignatura != null) {
            em.getTransaction().begin();
            for (Alumno alumno : asignatura.getAlumnos()) {
                alumno.getAsignaturas().remove(asignatura);
                em.merge(alumno);
                Profesor profesor = asignatura.getProfesor();
                if (profesor != null){
                    profesor.getAsignaturas().remove(asignatura);
                    em.merge(profesor);
                }
            }
            em.remove(asignatura);
            em.getTransaction().commit();
        } else {
            System.out.println("La asignatura con ID " + idAsignatura + " no existe.");
        }

        em.close();
    }

    public static void modificarProfesor (int idProfesor, String nuevoProfesor) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Profesor profesor = em.find(Profesor.class, idProfesor);

        if (profesor != null){
            em.getTransaction().begin();

            profesor.setNombre(nuevoProfesor);
            em.merge(profesor);
            em.getTransaction().commit();
            System.out.println("El profesor con ID: " + idProfesor + "ha sido modificado ");
        }else{
            System.out.println("El profesor con ID: " + idProfesor + "no existe ");
        }
        em.close();
    }
    public static void modificarAlumno (int idAlumno, String nuevoAlumno) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Alumno alumno = em.find(Alumno.class, idAlumno);

        if (alumno != null){
            em.getTransaction().begin();

            alumno.setNombre(nuevoAlumno);
            em.merge(alumno);
            em.getTransaction().commit();
            System.out.println("El profesor con ID: " + idAlumno + "ha sido modificado ");
        }else{
            System.out.println("El profesor con ID: " + idAlumno + "no existe ");
        }
        em.close();
}
    public static void modificarAsignatura (int idAsignatura, String nuevaAsignatura) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Asignatura asignatura = em.find(Asignatura.class, idAsignatura);

        if (asignatura != null){
            em.getTransaction().begin();

            asignatura.setNombre(nuevaAsignatura);
            em.merge(asignatura);
            em.getTransaction().commit();
            System.out.println("La asignatura con ID: " + idAsignatura + "ha sido modificada ");
        }else{
            System.out.println("La asignatura con ID: " + idAsignatura + "no existe ");
        }
        em.close();
}
}
