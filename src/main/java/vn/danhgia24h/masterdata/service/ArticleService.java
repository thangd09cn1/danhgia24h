package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.models.Article;
import vn.danhgia24h.masterdata.repositories.ArticleRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArticleService extends CrudService<Article,Long> {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository repository) {
        this.repository = this.articleRepository = repository;
    }

}
