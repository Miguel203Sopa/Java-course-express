package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sga.domain.Persona;

import java.util.logging.LogManager;

public class EncontrarObjetoJPA {


    private static final Logger log = LoggerFactory.getLogger(PersistirObjetoJPA.class);

    public static void main(String[] args) {
        System.out.println("comenzando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            //Inicia la transaccion

            tx.begin();

            //Ejecuta sql
            Persona persona1 = em.find(Persona.class,6);

            //termina transaccion
            tx.commit();

            //objeto en forma detached
            log.debug("Objeto recuperado"+persona1);
            log.info("Objeto Recuperado "+persona1);

            //cerramos el entity manager

//            em.close();
//            emf.close();

        }

    }
}
