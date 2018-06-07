package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.masterdata.models.Company;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.repositories.CompanyRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CompanyService extends CrudService<Company,Long> {

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

}
