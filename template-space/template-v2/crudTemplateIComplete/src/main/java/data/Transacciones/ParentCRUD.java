package data.Transacciones;

import data.domain.Parent;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ParentCRUD {


    @PersistenceContext(unitName = "templatePU")
    private EntityManager em;


    public void CrearRegistroPt(Parent parent) {

        em.persist(parent);
    }


    public List<Parent> listar() {
        return em.createNamedQuery("Parent.findAll", Parent.class)
                .getResultList();
    }


    public Parent buscar(Long id) {
        return em.find(Parent.class, id);
    }


    public void actualizar(Parent parent) {
        em.merge(parent);
    }


    public void EliminarRegistroPt(Long id) {
        Parent parent = em.find(Parent.class, id);
        if (parent != null) {
            em.remove(parent);
        }
    }
}
