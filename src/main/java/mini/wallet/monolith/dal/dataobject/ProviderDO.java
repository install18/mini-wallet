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
@Table(name = "`provider`")
public class ProviderDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String providerId;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    private String url;

    private String apiKey;
}
