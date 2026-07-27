package data.web;

import data.domain.Parent;
import data.service.ParentService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ParentBean implements Serializable {

    @EJB
    private ParentService service;

    private Parent parent;

    @PostConstruct
    public void init(){
        parent = new Parent();
    }

    public String save() {

        if(parent.getId() == null){
            service.create(parent);
        }else{
            service.update(parent);
        }

        init();
        return "Parent?faces-redirect=true";
    }

    public void edit(Parent p){
        this.parent = p;
    }


    public List<Parent> getParents() {
        return service.findAll();
    }

    public void  deleteB (Parent parent){
        service.delete(parent.getId());
    }

    public Parent getParent() { return parent; }

    public String viewDetails(Long id) {
        return "detail.xhtml?faces-redirect=true&parentId=" + id;
    }
}