package data.test;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class testConnection {

    @PersistenceContext(unitName="templatePU")
     private EntityManager em;

    public void pruebaCON() {
        em.createQuery("SELECT p FROM ParentDetail p").getResultList();
    }


}
