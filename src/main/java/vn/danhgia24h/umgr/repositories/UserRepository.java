package vn.danhgia24h.umgr.repositories;


import vn.danhgia24h.umgr.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import vn.danhgia24h.core.CustomJpaRepository;

/**
 * Created by quocvi3t on 11/13/17.
 */
@Repository
public interface UserRepository extends CustomJpaRepository<User,Long> {
    User findOneByEmailIgnoreCase(String  email);

    @EntityGraph(attributePaths = "roles")
    User findOneWithRolesById(Long id);

    @EntityGraph(attributePaths = "roles")
    User findOneWithRolesByEmail(String email);
}
