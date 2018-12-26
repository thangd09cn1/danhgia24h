package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "master_products")
public class Product extends IdEntity {

    @Column(nullable = false, unique = true)
    private String code;

    private String name;

    private String description;
    private String descriptionSort;
    private Integer setSale;
    private Integer setNew;
    private Integer setHot;

    private double cost;
    private double costSale;
    private Long costUomId;
    private double quantity;
    private Long uomId;
    private Long manufacturerId;
    private Long supplierId;
    private Integer availability;

    private Integer rate;
    private Integer ratePrice;
    private Integer rateQuality;
    private Integer rateValue;

    private String color;
    private String size;
    private String avartar;
    private String images;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionSort() {
        return descriptionSort;
    }

    public void setDescriptionSort(String descriptionSort) {
        this.descriptionSort = descriptionSort;
    }

    public Integer getSetSale() {
        return setSale;
    }

    public void setSetSale(Integer setSale) {
        this.setSale = setSale;
    }

    public Integer getSetNew() {
        return setNew;
    }

    public void setSetNew(Integer setNew) {
        this.setNew = setNew;
    }

    public Integer getSetHot() {
        return setHot;
    }

    public void setSetHot(Integer setHot) {
        this.setHot = setHot;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCostSale() {
        return costSale;
    }

    public void setCostSale(double costSale) {
        this.costSale = costSale;
    }

    public Long getCostUomId() {
        return costUomId;
    }

    public void setCostUomId(Long costUomId) {
        this.costUomId = costUomId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
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

    public Integer getRateValue() {
        return rateValue;
    }

    public void setRateValue(Integer rateValue) {
        this.rateValue = rateValue;
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

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
