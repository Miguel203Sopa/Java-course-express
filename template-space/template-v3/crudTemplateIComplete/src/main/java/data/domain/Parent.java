package data.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PARENT")
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(name = "ENABLED")
    private Integer enabled;

    @OneToMany(mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ParentDetail> details = new ArrayList<>();

    public void addDetail(ParentDetail detail) {
        detail.setParent(this);
        details.add(detail);
    }

    public void removeDetail(ParentDetail detail) {
        details.remove(detail);
        detail.setParent(null);
    }

    public Long getId() { return id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getEnabled() { return enabled; }
    public void setEnabled(Integer enabled) { this.enabled = enabled; }

    public Long getCreated_by() {return this.createdBy;}
    public void setCreatedBy(Long createdBy){ this.createdBy = createdBy;}



    public List<ParentDetail> getDetails() { return details; }
}