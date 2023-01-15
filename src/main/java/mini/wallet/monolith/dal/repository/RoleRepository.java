package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleDO, String> {
    Optional<RoleDO> queryByRoleId(String roleId);
}
