package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.CustomerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerDO, String> {
    Optional<CustomerDO> queryByPhoneNumber(String phoneNumber);

    Optional<CustomerDO> queryByEmail(String email);
}
