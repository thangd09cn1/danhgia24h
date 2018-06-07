package vn.danhgia24h.masterdata.repositories;

import vn.danhgia24h.core.CustomJpaRepository;
import vn.danhgia24h.masterdata.models.Uom;

public interface UomRepository extends CustomJpaRepository<Uom,Long> {
    Uom findByName(String name);
}
