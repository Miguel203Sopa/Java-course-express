
package data.web;

import data.Transacciones.ParentCRUD;
import data.Transacciones.ParentDetailCRUD;
import data.domain.Parent;
import data.domain.ParentDetail;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("detailBean")
@ViewScoped
public class ParentDetailBean implements Serializable {

    @EJB
    private ParentCRUD parentCRUD;

    @EJB
    private ParentDetailCRUD detailCRUD;



    private Long parentId;
    private Parent parent;
    private List<ParentDetail> detalles;
    private ParentDetail nuevoDetalle = new ParentDetail();

    public void cargar() {

        if (parentId == null) {
            return;
        }

        parent = parentCRUD.buscar(parentId);
        detalles = detailCRUD.listarPorParent(parentId);
    }

    public void agregarDetalle() {
        nuevoDetalle.setIdParent(parent);
        detailCRUD.crear(nuevoDetalle);
        nuevoDetalle = new ParentDetail();
        detalles = detailCRUD.listarPorParent(parent.getId());
    }

    public void eliminarDetalle(Long id) {
        detailCRUD.eliminar(id);
        detalles = detailCRUD.listarPorParent(parent.getId());
    }



    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Parent getParent() { return parent; }
    public List<ParentDetail> getDetalles() { return detalles; }
    public ParentDetail getNuevoDetalle() { return nuevoDetalle; }
}
