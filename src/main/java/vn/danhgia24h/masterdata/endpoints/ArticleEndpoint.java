package vn.danhgia24h.masterdata.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.models.Article;
import vn.danhgia24h.masterdata.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleEndpoint extends CrudApiEndpoint<Article,Long> {

    private ArticleService articleService;

    @Autowired
    public ArticleEndpoint(ArticleService service) {
        super(service);
        this.articleService = service;
        this.baseUrl = "/api/articles";
    }

}
