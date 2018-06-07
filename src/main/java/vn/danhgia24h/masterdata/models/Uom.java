package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "master_uom")
public class Uom extends IdEntity {

    private String type;
    private Double factor;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer categoryId;


    private Double rounding;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public Double getRounding() {
        return rounding;
    }

    public void setRounding(Double rounding) {
        this.rounding = rounding;
    }
}