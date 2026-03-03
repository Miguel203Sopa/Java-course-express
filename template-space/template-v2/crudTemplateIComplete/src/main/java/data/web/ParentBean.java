package data.web;

import data.Transacciones.ParentCRUD;
import data.domain.Parent;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("parentBean")
@ViewScoped
public class ParentBean implements Serializable {

    @EJB
    private ParentCRUD parentCRUD;

    private List<Parent> lista;

    private Parent parent = new Parent();

    @PostConstruct
    public void init() {
        lista = parentCRUD.listar();
    }

    public void guardar() {
        parentCRUD.CrearRegistroPt(parent);
        parent = new Parent();
        lista = parentCRUD.listar();
    }

    public void eliminar(Long id) {
        parentCRUD.EliminarRegistroPt(id);
        lista = parentCRUD.listar();
    }

    // getters
    public List<Parent> getLista() { return lista; }
    public Parent getParent() { return parent; }
}
