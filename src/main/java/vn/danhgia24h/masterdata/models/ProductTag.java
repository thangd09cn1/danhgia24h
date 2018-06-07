package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "master_product_tags")
public class ProductTag extends IdEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private Long productId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
