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

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet")
public class WalletDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String walletId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String balance;
}
