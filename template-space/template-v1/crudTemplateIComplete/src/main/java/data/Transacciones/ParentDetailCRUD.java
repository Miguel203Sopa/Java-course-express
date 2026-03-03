package data.Transacciones;

import data.domain.Parent;
import data.domain.ParentDetail;
import data.test.testConnection;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;

@Stateless
public class ParentDetailCRUD {

    public ParentDetailCRUD() {}

    @EJB
    private testConnection tc;
    @PersistenceContext(unitName="templatePU")
    private EntityManager em;
    public ParentDetail pd = new ParentDetail();

    public void CrearRegistroPt(Long Id, String Name, Long Quantity, Parent idParent, Long createdBy, LocalDate createdAt, Long updatedBy, LocalDate updatedAt, Boolean enabled){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

            ParentDetail pd = new ParentDetail(Id,Name,Quantity, idParent, createdBy, createdAt, updatedBy,updatedAt,enabled);
            em.persist(pd);

            //em.close();
        }

    }
    public void MirarRegistroPt(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

          ParentDetail  pd = em.find(ParentDetail.class, id);


            //em.close();
        }
    }
    public void ActualizarRegistroPt(Long Id, String Name, Long Quantity, Parent idParent, Long createdBy, LocalDate createdAt, Long updatedBy, LocalDate updatedAt, Boolean enabled){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){


            ParentDetail p1 = em.find(ParentDetail.class, Id);

            //Set Values
            p1.setId(Id);
            p1.setName(Name);
            p1.setQuantity(Quantity);
            p1.setIdParent(idParent);
            p1.setCreatedBy(createdBy);
            p1.setCreatedAt(createdAt);
            p1.setUpdatedBy(updatedBy);
            p1.setUpdatedAt(updatedAt);
            p1.setEnabled(enabled);
            em.merge(p1);



        }
    }
    public void EliminarRegistroPt(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parentPU");
        try(EntityManager em = emf.createEntityManager()){

            ParentDetail p1 = em.find(ParentDetail.class, id);
            em.remove(em.merge(p1));

        }
    }



}
