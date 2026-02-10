package sga.cliente.ciclodevida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sga.domain.Persona;

public class ActualizarObjetoJPA {


    private static final Logger log = LoggerFactory.getLogger(PersistirObjetoJPA.class);

    public static void main(String[] args) {
        System.out.println("comenzando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            //Inicia la transaccion

            tx.begin();

            //Ejecuta sql BUSCAMOS UN REGISTRO EXISTENTE
            Persona persona1 = em.find(Persona.class,6);

            //termina la transacccion
            tx.commit();

            log.info("Persona a actualizar "+persona1);

            //set value (nuevo valor)

            persona1.setApellido("Tranquino");


            //em.close(); se deberia hacer esto en caso de no hacer flush

            //nueva transaccion
            EntityTransaction tx2 = em.getTransaction();
            tx2.begin();

            //modificamos el objeto
            em.merge(persona1);

            //guardamos las modificaciones
            tx2.commit();

            //revisamos los cambios
            log.info("Nuevo valor cambiado "+persona1);

           // em.flush();
            //permite vaciar cualquier cambio o modificacion de algun sql pendiente sin terminar la transaccion

            //em.close();




        }

    }
}
