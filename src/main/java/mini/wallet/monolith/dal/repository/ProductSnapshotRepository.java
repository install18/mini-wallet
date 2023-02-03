package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.ProductSnapshotDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSnapshotRepository extends JpaRepository<ProductSnapshotDO, String> {
}
