package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "master_products")
public class Product extends IdEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    private Integer sale;
    private Integer news;
    private Integer hot;

    private Long cost;
    private Long costUomId;
    private Long quantity;
    private Long quantityUomId;
    private Long companyId;

    private String image;
    private String status;

    private Integer ratePrice;
    private Integer rateQuality;

    private String descriptionSort;
    private String color;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getNews() {
        return news;
    }

    public void setNews(Integer news) {
        this.news = news;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCostUomId() {
        return costUomId;
    }

    public void setCostUomId(Long costUomId) {
        this.costUomId = costUomId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantityUomId() {
        return quantityUomId;
    }

    public void setQuantityUomId(Long quantityUomId) {
        this.quantityUomId = quantityUomId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(Integer ratePrice) {
        this.ratePrice = ratePrice;
    }

    public Integer getRateQuality() {
        return rateQuality;
    }

    public void setRateQuality(Integer rateQuality) {
        this.rateQuality = rateQuality;
    }

    public String getDescriptionSort() {
        return descriptionSort;
    }

    public void setDescriptionSort(String descriptionSort) {
        this.descriptionSort = descriptionSort;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
