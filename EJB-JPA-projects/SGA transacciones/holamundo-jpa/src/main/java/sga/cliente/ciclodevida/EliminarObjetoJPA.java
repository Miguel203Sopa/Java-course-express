package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sga.domain.Persona;

public class EliminarObjetoJPA
{
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

            //termina transaccion 1
            tx.commit();

            log.info("Objeto encontrado "+persona1);

            em.close();

            //nueva tx
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();

            //sincronizar cambios y de ahi borrar
            em.remove(em.merge(persona1));

            //cerramos transaccion2
            tx2.commit();

            log.info("Objeto eliminado"+persona1);




            //em.close();




        }

    }
}
