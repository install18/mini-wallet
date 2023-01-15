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
import mini.wallet.monolith.model.snapshot.ProductSnapshot;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class OrderDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String orderId;

    @Column(nullable = false)
    private String invoiceId;

    @Column(nullable = false)
    private List<ProductSnapshot> productSnapshotList;

    @Column(nullable = false)
    private String status;
}
