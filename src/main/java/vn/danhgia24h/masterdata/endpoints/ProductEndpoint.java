package vn.danhgia24h.masterdata.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.models.Product;
import vn.danhgia24h.masterdata.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductEndpoint extends CrudApiEndpoint<Product,Long> {

    private static Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);
    private ProductService productService;

    @Autowired
    public ProductEndpoint(ProductService service) {
        super(service);
        this.productService = service;
        this.baseUrl = "/api/products";
    }

}
