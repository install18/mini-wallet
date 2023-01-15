package mini.wallet.monolith.dal.dataobject;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mini.wallet.monolith.model.base.BaseDataObject;
import mini.wallet.monolith.model.snapshot.MerchantProductSnapshot;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class InvoiceDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String invoiceId;

    @Column(nullable = false)
    private String merchantId;

    @Column(nullable = false)
    private List<MerchantProductSnapshot> merchantProductSnapshotList;

    @Column(nullable = false)
    private String status;
}
