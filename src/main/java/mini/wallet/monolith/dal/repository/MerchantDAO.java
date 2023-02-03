package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.MerchantDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDAO extends JpaRepository<MerchantDO, String> {
}
