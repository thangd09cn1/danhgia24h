package vn.danhgia24h.masterdata.endpoints;

import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.service.UomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.masterdata.models.UomCategory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/uom-categories")
public class UomCategoryEndpoint extends CrudApiEndpoint<UomCategory,Long> {

    private UomCategoryService uomCategoryService;

    @Autowired
    public UomCategoryEndpoint(UomCategoryService service) {
        super(service);
        this.uomCategoryService = service;
        this.baseUrl = "/api/uom-category";
    }

    @RequestMapping(path = "/tree", method = RequestMethod.GET)
    public @ResponseBody
    List<Map<String, Object>> getCategoryTree() {
        return uomCategoryService.builCategoryTree();
    }

}
