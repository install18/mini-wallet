package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.ProviderProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderProductRepository extends JpaRepository<ProviderProductDO, String> {
    Optional<ProviderProductDO> queryByProductId(String transactionId);
}
