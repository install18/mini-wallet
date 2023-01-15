package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDO, String> {
}
