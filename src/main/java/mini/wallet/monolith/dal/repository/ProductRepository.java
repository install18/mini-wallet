package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDO, String> {
}
