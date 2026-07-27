package data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


    //

@NamedQueries({



        @NamedQuery(name= "ParentDetail.findAll", query ="SELECT pd FROM ParentDetail pd"),
        @NamedQuery(name= "ParentDetail.findByID", query ="SELECT pd FROM ParentDetail pd WHERE pd.id =:ID"),

        @NamedQuery(name= "ParentDetail.findByNAME", query ="SELECT pd FROM ParentDetail pd WHERE pd.name =:NAME"),
        @NamedQuery(name= "ParentDetail.findByQUANTITY", query ="SELECT pd FROM ParentDetail pd WHERE pd.quantity =:QUANTITY"),
        @NamedQuery(name= "ParentDetail.findByID_PARENT", query ="SELECT pd FROM ParentDetail pd WHERE pd.idParent =:ID_PARENT"),

        @NamedQuery(name= "ParentDetail.findByCREATED_BY", query ="SELECT pd FROM ParentDetail pd WHERE pd.createdBy =:CREATED_BY"),
        @NamedQuery(name= "ParentDetail.findByCREATED_AT", query ="SELECT pd FROM ParentDetail pd WHERE pd.createdAt =:CREATED_AT"),
        @NamedQuery(name= "ParentDetail.findByUPDATED_BY", query ="SELECT pd FROM ParentDetail pd WHERE pd.updatedBy =:UPDATED_BY"),
        @NamedQuery(name= "ParentDetail.findByUPDATED_AT", query ="SELECT pd FROM ParentDetail pd WHERE pd.updatedAt =:UPDATED_AT"),
        @NamedQuery(name= "ParentDetail.findByENABLED", query ="SELECT pd FROM ParentDetail pd WHERE pd.enabled =:ENABLED")
})

@Entity
@Table(name = "PARENT_DETAIL")
public class ParentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PARENT", nullable = false)
    private Parent idParent;

    @NotNull
    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @NotNull
    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;


    public ParentDetail(){}


    public ParentDetail( String Name, Long Quantity, Parent idParent, Long createdBy, LocalDate createdAt, Long updatedBy, LocalDate updatedAt, Boolean enabled) {

        this.setName(Name);
        this.setQuantity(Quantity);
        this.setIdParent(idParent);
        this.setCreatedBy(createdBy);
        this.setCreatedAt(createdAt);
        this.setUpdatedBy(updatedBy);
        this.setUpdatedAt(updatedAt);
        this.setEnabled(enabled);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Parent getIdParent() {
        return idParent;
    }

    public void setIdParent(Parent idParent) {
        this.idParent = idParent;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}