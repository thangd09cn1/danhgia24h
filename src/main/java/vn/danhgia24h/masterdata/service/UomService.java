package vn.danhgia24h.masterdata.service;

import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.core.errors.BadRequestAlertException;
import org.springframework.stereotype.Service;
import vn.danhgia24h.masterdata.models.Uom;
import vn.danhgia24h.masterdata.repositories.UomRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UomService extends CrudService<Uom,Long> {
    private UomRepository uomRepository;

    public UomService(UomRepository repository) {
        this.repository = this.uomRepository = repository;
    }

    @Override
    protected void beforeCreate(Uom entity) {
        super.beforeCreate(entity);

        if(this.uomRepository.findByName(entity.getName()) != null) {
            throw new BadRequestAlertException("Duplicate UOM name","uom","nameExist");
        }

    }

    @Override
    protected void beforeUpdate(Uom entity) {
        super.beforeUpdate(entity);

        Uom uom = this.uomRepository.findByName(entity.getName());
        if(uom != null && !uom.getId().equals(entity.getId())) {
            throw new BadRequestAlertException("Duplicate UOM name","uom","nameExist");
        }
    }
}
