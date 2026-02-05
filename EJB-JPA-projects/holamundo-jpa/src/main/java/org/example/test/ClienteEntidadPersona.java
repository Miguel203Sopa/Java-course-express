package org.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Persona;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class ClienteEntidadPersona {
    static Logger log= LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //no se debe especificar el ID

        Persona persona1 = new Persona("Juliana", "Salguero", "cas@gmail.com", "22432422");
        log.debug("objeto a persistir " + persona1);
        em.persist(persona1);
        tx.commit();
        log.debug("Objeto persistido" + persona1);
        em.close();

    }
}
