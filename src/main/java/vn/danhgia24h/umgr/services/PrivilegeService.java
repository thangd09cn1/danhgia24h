package vn.danhgia24h.umgr.services;

import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.umgr.models.Privilege;
import vn.danhgia24h.umgr.repositories.PrivilegeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by quocvi3t on 11/16/17.
 */
@Service
@Transactional
public class PrivilegeService extends CrudService<Privilege,Long> {
    private PrivilegeRepository privilegeRepository;
    public PrivilegeService(PrivilegeRepository repository) {
        this.repository = this.privilegeRepository = repository;
    }

    public Privilege findOneByName(String name) {
        return this.privilegeRepository.findOneByName(name);
    }
}
