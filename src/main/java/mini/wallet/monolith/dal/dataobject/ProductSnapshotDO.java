package mini.wallet.monolith.dal.dataobject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mini.wallet.monolith.model.base.BaseDataObject;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`product_snapshot`")
public class ProductSnapshotDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String productSnapshotId;

    @Column(nullable = false)
    private String productSnapshotName;

    private String description;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String merchantId;
}
