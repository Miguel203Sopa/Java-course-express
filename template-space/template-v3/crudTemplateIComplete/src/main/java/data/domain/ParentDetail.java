package data.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "PARENT_DETAIL")
public class ParentDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PARENT")
    private Parent parent;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "ENABLED")
    private Integer enabled;


    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
}
