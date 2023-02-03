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

import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`transaction`")
public class TransactionDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String transactionId;

    @NotBlank
    private String transactionType;

    @NotBlank
    private BigDecimal amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String customerId;

    @NotBlank
    private String productId;

    @NotBlank
    private String productSnapshotId;

    @NotBlank
    private String providerId;

    @NotBlank
    private String status;
}
