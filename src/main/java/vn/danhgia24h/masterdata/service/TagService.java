package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.models.Tag;
import vn.danhgia24h.masterdata.repositories.TagRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class TagService extends CrudService<Tag,Long> {

    private TagRepository tagRepository;

    public TagService(TagRepository repository) {
        this.repository = this.tagRepository = repository;
    }

}
