package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.MerchantProductDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantProductRepository extends JpaRepository<MerchantProductDO, String> {
}
