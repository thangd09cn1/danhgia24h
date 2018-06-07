package vn.danhgia24h.masterdata.endpoints;

import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.service.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.masterdata.models.Uom;

@RestController
@RequestMapping("/api/uoms")
public class UomEndpoint extends CrudApiEndpoint<Uom,Long> {

    private UomService uomService;

    @Autowired
    public UomEndpoint(UomService service) {
        super(service);
        this.uomService = service;
        this.baseUrl = "/api/uom";
    }

}
