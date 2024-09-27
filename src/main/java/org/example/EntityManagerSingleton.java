package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EntityManagerSingleton {
        private static EntityManagerFactory emf;

        public static EntityManager getEntityManager() {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("TEST_PERSISTENCE_JPA");
            }
            EntityManager em = emf.createEntityManager();
            return em;
        }
    }
