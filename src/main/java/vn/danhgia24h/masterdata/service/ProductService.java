package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.models.Product;
import vn.danhgia24h.masterdata.repositories.ProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService extends CrudService<Product,Long> {

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

}
