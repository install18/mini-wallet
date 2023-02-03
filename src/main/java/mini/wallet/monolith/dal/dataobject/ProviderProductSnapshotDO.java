package mini.wallet.monolith.dal.dataobject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "`provider_product_snapshot`")
public class ProviderProductSnapshotDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String providerProductSnapshotId;

    @NotBlank
    private String productSnapshotId;

    @NotBlank
    private String providerId;

    @NotBlank
    private String price;
}
