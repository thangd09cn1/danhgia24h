package vn.danhgia24h.masterdata.endpoints;

import vn.danhgia24h.masterdata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.danhgia24h.masterdata.models.Company;
import vn.danhgia24h.core.CrudApiEndpoint;


@RestController
@RequestMapping("/api/companies")
public class CompanyEndpoint extends CrudApiEndpoint<Company,Long> {

    private CompanyService companyService;

    @Autowired
    public CompanyEndpoint(CompanyService service) {
        super(service);
        this.companyService = service;
        this.baseUrl = "/api/companies";
    }

}
