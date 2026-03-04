package data.web;

import data.domain.Parent;
import data.domain.ParentDetail;
import data.service.ParentService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class ParentDetailBean implements Serializable {

    @EJB
    private ParentService parentService;

    private Parent parent;
    private ParentDetail newDetail = new ParentDetail();

    private Long parentId;

    @PostConstruct
    public void init() {
        Map<String, String> params =
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getRequestParameterMap();

        parentId = Long.valueOf(params.get("parentId"));

        parent = parentService.find(parentId);
    }


    public void addDetail() {
        parent.addDetail(newDetail);
        parentService.create(parent);

        newDetail = new ParentDetail();
    }


    public void removeDetail(ParentDetail d) {
        parent.removeDetail(d);
        parentService.create(parent);
    }


    public Parent getParent() { return parent; }

    public ParentDetail getNewDetail() { return newDetail; }

    public List<ParentDetail> getDetails() {
        return parent.getDetails();
    }
}