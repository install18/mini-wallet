package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.TransactionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionDAO extends JpaRepository<TransactionDO, String> {
    Optional<TransactionDO> queryByCustomerId(String customerId);
}
