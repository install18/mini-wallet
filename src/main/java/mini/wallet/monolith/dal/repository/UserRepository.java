package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDO, String> {
    Optional<UserDO> queryByPhoneNumber(String phoneNumber);

    Optional<UserDO> queryByEmail(String email);
}
