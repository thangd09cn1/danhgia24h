package vn.danhgia24h.masterdata.models;

import vn.danhgia24h.core.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "master_tags")
public class Tag extends IdEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private Long articleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
