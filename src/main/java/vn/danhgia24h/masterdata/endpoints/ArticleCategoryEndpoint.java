package vn.danhgia24h.masterdata.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.models.ArticleCategory;
import vn.danhgia24h.masterdata.service.ArticleCategoryService;

@RestController
@RequestMapping("/api/article-categories")
public class ArticleCategoryEndpoint extends CrudApiEndpoint<ArticleCategory,Long> {

    private static Logger logger = LoggerFactory.getLogger(ArticleCategoryEndpoint.class);
    private ArticleCategoryService articleCategoryService;

    @Autowired
    public ArticleCategoryEndpoint(ArticleCategoryService service) {
        super(service);
        this.articleCategoryService = service;
        this.baseUrl = "/api/article-categories";
    }

}
