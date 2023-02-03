package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.ProviderProductSnapshotDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderProductSnapshotRepository extends JpaRepository<ProviderProductSnapshotDO, String> {
    Optional<ProviderProductSnapshotDO> queryByProductSnapshotId(String transactionId);
}
