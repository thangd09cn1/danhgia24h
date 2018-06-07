package vn.danhgia24h.masterdata.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.models.Tag;
import vn.danhgia24h.masterdata.service.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagEndpoint extends CrudApiEndpoint<Tag,Long> {

    private TagService tagService;

    @Autowired
    public TagEndpoint(TagService service) {
        super(service);
        this.tagService = service;
        this.baseUrl = "/api/tags";
    }

}
