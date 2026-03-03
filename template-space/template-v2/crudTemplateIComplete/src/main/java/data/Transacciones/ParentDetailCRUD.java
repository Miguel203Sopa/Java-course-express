package data.Transacciones;

import data.domain.ParentDetail;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ParentDetailCRUD {

    @PersistenceContext(unitName = "templatePU")
    private EntityManager em;


    public void crear(ParentDetail detail) {
        em.persist(detail);
    }


    public List<ParentDetail> listarPorParent(Long parentId) {
        return em.createQuery(
                        "SELECT d FROM ParentDetail d WHERE d.parent.id = :id",
                        ParentDetail.class)
                .setParameter("id", parentId)
                .getResultList();
    }

    public ParentDetail buscar(Long id) {
        return em.find(ParentDetail.class, id);
    }


    public void actualizar(ParentDetail detail) {
        em.merge(detail);
    }


    public void eliminar(Long id) {
        ParentDetail detail = em.find(ParentDetail.class, id);
        if (detail != null) {
            em.remove(detail);
        }
    }
}
