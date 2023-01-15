package mini.wallet.monolith.dal.repository;

import mini.wallet.monolith.dal.dataobject.InvoiceDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceDO, String> {

}
