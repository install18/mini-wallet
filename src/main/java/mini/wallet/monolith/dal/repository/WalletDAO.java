package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.WalletDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletDAO extends JpaRepository<WalletDO, String> {
    Optional<WalletDO> queryByCustomerId(String customerId);
}
