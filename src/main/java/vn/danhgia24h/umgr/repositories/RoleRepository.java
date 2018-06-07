package vn.danhgia24h.umgr.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import vn.danhgia24h.core.CustomJpaRepository;
import vn.danhgia24h.umgr.models.Role;

/**
 * Created by quocvi3t on 11/13/17.c
 */
public interface RoleRepository extends CustomJpaRepository<Role,Long> {
    @EntityGraph(attributePaths = {"privileges","users"})
    Role findOneWithPrivilegesById(Long id);


}

