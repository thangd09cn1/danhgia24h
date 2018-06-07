package vn.danhgia24h.umgr.services;

import vn.danhgia24h.core.errors.RoleHasNoPrivilegeException;
import vn.danhgia24h.umgr.models.Role;
import vn.danhgia24h.umgr.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;

import javax.transaction.Transactional;

/**
 * Created by quocvi3t on 11/16/17.
 */
@Service
@Transactional
public class RoleService extends CrudService<Role,Long> {
    RoleRepository roleRepository;
    public RoleService(RoleRepository repository) {
        this.repository = this.roleRepository = repository;
    }

    @Override
    public Role get(Long id) {
        return this.roleRepository.findOneWithPrivilegesById(id);
    }

    @Override
    protected void beforeCreate(Role entity) {
        super.beforeCreate(entity);

        if(entity.getPrivileges().isEmpty())
            throw new RoleHasNoPrivilegeException();
    }
}
