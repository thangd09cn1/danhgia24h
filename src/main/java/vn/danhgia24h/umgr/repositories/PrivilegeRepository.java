package vn.danhgia24h.umgr.repositories;

import vn.danhgia24h.core.CustomJpaRepository;
import vn.danhgia24h.umgr.models.Privilege;

/**
 * Created by quocvi3t on 11/13/17.
 */
public interface PrivilegeRepository extends CustomJpaRepository<Privilege,Long> {
    Privilege findOneByName(String name);
}
