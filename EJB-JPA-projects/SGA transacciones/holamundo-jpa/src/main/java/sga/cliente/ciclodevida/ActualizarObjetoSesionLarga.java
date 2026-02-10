package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sga.domain.Persona;

public class ActualizarObjetoSesionLarga {
    private static final Logger log = LoggerFactory.getLogger(PersistirObjetoJPA.class);

    public static void main(String[] args) {
        System.out.println("comenzando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            //Inicia la transaccion

            tx.begin();

            //ejecutamos SELECT en SQL
            Persona persona1= em.find(Persona.class,5);

            //objeto encontrado:
            log.info("objeto recuperado: "+persona1);

            //set value
            persona1.setEmail("T@gmail.com");
            persona1.setEmail("TT@gmail.com");

            tx.commit();

            log.info("Objeto Modificado: "+persona1);

            //em.close();




        }

    }
}
