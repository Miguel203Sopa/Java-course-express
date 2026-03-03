package data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

@Entity

@NamedQueries({
        @NamedQuery(name= "Parent.findAll", query ="SELECT p FROM Parent p"),
        @NamedQuery(name= "Parent.findByID", query ="SELECT p FROM Parent p WHERE p.id =:ID"),
        @NamedQuery(name= "Parent.findByCODE", query ="SELECT p FROM Parent p WHERE p.code =:CODE"),
        @NamedQuery(name= "Parent.findByNAME", query ="SELECT p FROM Parent p WHERE p.name =:NAME"),
        @NamedQuery(name= "Parent.findBySTATUS", query ="SELECT p FROM Parent p WHERE p.status =:STATUS"),

        @NamedQuery(name= "Parent.findByCREATED_BY", query ="SELECT p FROM Parent p WHERE p.createdBy =:CREATED_BY"),
        @NamedQuery(name= "Parent.findByCREATED_AT", query ="SELECT p FROM Parent p WHERE p.createdAt =:CREATED_AT"),
        @NamedQuery(name= "Parent.findByUPDATED_BY", query ="SELECT p FROM Parent p WHERE p.updatedBy =:UPDATED_BY"),
        @NamedQuery(name= "Parent.findByUPDATED_AT", query ="SELECT p FROM Parent p WHERE p.updatedAt =:UPDATED_AT"),
        @NamedQuery(name= "Parent.findByENABLED", query ="SELECT p FROM Parent p WHERE p.enabled =:eENABLED")




})

@Table(name = "PARENT")
public class Parent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "CODE", nullable = false)
    private String code;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Size(max = 9)
    @NotNull
    @Column(name = "STATUS", nullable = false, length = 9)
    private String status;

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

    public Parent(Long id, String Code, String Name, String Status, Long CreatedBy, LocalDate CreatedAt, Long UpdatedBy, LocalDate UpdatedAt, Boolean enabled) {
        this.setId(id);
        this.setCode(Code);
        this.setName(Name);
        this.setStatus(Status);
        this.setCreatedBy(CreatedBy);
        this.setCreatedAt(CreatedAt);
        this.setUpdatedBy(UpdatedBy);
        this.setUpdatedAt(UpdatedAt);
        this.setEnabled(enabled);
    }

    public Parent(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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