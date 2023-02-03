package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.RetrialTaskDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetrialTaskRepository extends JpaRepository<RetrialTaskDO, String> {
    Optional<RetrialTaskDO> queryByTransactionId(String transactionId);
}
