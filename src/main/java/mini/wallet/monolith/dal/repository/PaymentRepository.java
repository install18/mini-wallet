package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.PaymentDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDO, String> {
}
