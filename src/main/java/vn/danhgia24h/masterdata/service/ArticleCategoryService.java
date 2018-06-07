package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.models.ArticleCategory;
import vn.danhgia24h.masterdata.repositories.ArticleCategoryRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArticleCategoryService extends CrudService<ArticleCategory,Long> {

    public ArticleCategoryService(ArticleCategoryRepository repository) {
        this.repository = repository;
    }

}
