package vn.danhgia24h.masterdata.endpoints;

import vn.danhgia24h.masterdata.models.Category;
import vn.danhgia24h.masterdata.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.danhgia24h.core.CrudApiEndpoint;

import java.util.List;
import java.util.Map;

/**
 * Created by quocvi3t on 11/14/17.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryEndpoint extends CrudApiEndpoint<Category,Long> {

    private static Logger logger = LoggerFactory.getLogger(CategoryEndpoint.class);
    private CategoryService categoryService;

    @Autowired
    public CategoryEndpoint(CategoryService service) {
        super(service);
        this.categoryService = service;
        this.baseUrl = "/api/product-categories";
    }

    @RequestMapping(path = "/category-tree", method = RequestMethod.GET)
    public @ResponseBody
    List<Map<String, Object>> getCategoryTree() {
        return categoryService.builCategoryTree();
    }
}
