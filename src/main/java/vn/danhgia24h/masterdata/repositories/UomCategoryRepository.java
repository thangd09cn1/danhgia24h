package vn.danhgia24h.masterdata.repositories;

import vn.danhgia24h.core.CustomJpaRepository;
import vn.danhgia24h.masterdata.models.UomCategory;

public interface UomCategoryRepository extends CustomJpaRepository<UomCategory,Long> {
    UomCategory findByName(String name);
}
