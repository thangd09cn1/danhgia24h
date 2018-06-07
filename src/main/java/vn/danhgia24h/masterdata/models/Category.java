package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.*;

@Entity
@Table(name = "master_categories")
public class Category extends IdEntity {
    @Column(unique = true, nullable = false)
    private String name;

    private String description;
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
