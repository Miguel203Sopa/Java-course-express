package data.Transacciones;
import data.domain.Parent;
import data.test.testConnection;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.time.LocalDate;

@Stateless
public class ParentCRUD {

    public ParentCRUD() {}


    @EJB
    private  testConnection tc;

    @PersistenceContext(unitName="templatePU")
    private EntityManager em;

    public Parent  pa = new Parent();


    public void CrearRegistroPt(Long id, String Code, String Name, String Status, Long CreatedBy, LocalDate CreatedAt, Long UpdatedBy, LocalDate UpdatedAt, Boolean enabled ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

            Parent p1 = new Parent(id, Code, Name, Status, CreatedBy, CreatedAt, UpdatedBy, UpdatedAt, enabled);
            em.persist(p1);

            //em.close();
        }

    }
    public void MirarRegistroPt(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

            Parent p1 = em.find(Parent.class, id);


            //em.close();
        }
    }
    public void ActualizarRegistroPt(Long id, String Code, String Name, String Status, Long CreatedBy, LocalDate CreatedAt, Long UpdatedBy, LocalDate UpdatedAt, Boolean enabled){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){


            Parent p1 = em.find(Parent.class, id);

            //Set Values
            p1.setId(id);
            p1.setCode(Code);
            p1.setName(Name);
            p1.setStatus(Status);
            p1.setCreatedBy(CreatedBy);
            p1.setCreatedAt(CreatedAt);
            p1.setUpdatedBy(UpdatedBy);
            p1.setUpdatedAt(UpdatedAt);
            p1.setEnabled(enabled);
            em.merge(p1);



        }
    }
    public void EliminarRegistroPt(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

            Parent p1 = em.find(Parent.class, id);
            em.remove(em.merge(p1));

        }
    }





}
