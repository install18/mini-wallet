package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.WalletDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletDO, String> {
    Optional<WalletDO> queryByUserId(String userId);
}
