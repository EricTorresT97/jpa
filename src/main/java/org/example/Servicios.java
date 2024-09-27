package org.example;

import javax.persistence.EntityManager;
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
        Asignatura a = new Asignatura();
        // TODO pq no logro salvar la asignatura? me da el error Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist: org.example.Asignatura
        a.setNombre("kkkkkkkkkkkkk");
        em.persist(a);
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
        em.persist(idProfesor);
        em.persist(idAsignatura);
        em.getTransaction().commit();
        em.close();
    }

    public static void vincularAlumnoAsignatura (int idAlumno, int idAsignatura){
        EntityManager em = EntityManagerSingleton.getEntityManager();
        Profesor profesor = em.find(Profesor.class, idAlumno);
        Asignatura asignatura = em.find(Asignatura.class, idAsignatura);
        profesor.getAsignaturas().add(asignatura);
        asignatura.setProfesor(profesor);
        em.getTransaction().begin();
        em.persist(idAlumno);
        em.persist(idAsignatura);
        em.getTransaction().commit();
        em.close();
    }

//    List<Profesor> listaProfesor(){
//        EntityManager em = EntityManagerSingleton.getEntityManager();
//        Profesor profesor = new Profesor();
//        List<Profesor> profesores = profesor.get(em);
//        em.close();
//        return profesores;
//    }
}
