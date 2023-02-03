package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.ProviderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderDO, String> {
}
