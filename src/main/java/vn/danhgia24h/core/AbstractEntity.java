package vn.danhgia24h.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by quocvi3t on 11/11/17.
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private Long created;
    private Long updated;
    private String createdBy;
    private String updatedBy;
    @JsonIgnore
    private Integer active;

    public void setActive(Integer active) {
        this.active = active;
    }

    @JsonProperty
    public void setActive(Boolean active) {
        this.active = active ? 1 : 0;
    }

    @JsonProperty
    public Boolean isActive() {
        return active != null && active == 1;
    }

    public Integer getActive() {
        return active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }



    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }
}
