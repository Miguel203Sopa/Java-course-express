package data.service;

import data.domain.Parent;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

@Stateless
public class ParentService {

    @PersistenceContext(unitName = "templatePU")
    private EntityManager em;

    public void create(Parent parent) {

        parent.setCreatedAt(new Date());
        em.persist(parent);
    }

    public List<Parent> findAll() {
        return em.createQuery("SELECT p FROM Parent p", Parent.class)
                .getResultList();
    }

    public Parent find(Long id) {
        return em.find(Parent.class, id);
    }

    public void delete(Long id) {
        Parent p = em.find(Parent.class, id);
        if (p != null) em.remove(p);
    }
}