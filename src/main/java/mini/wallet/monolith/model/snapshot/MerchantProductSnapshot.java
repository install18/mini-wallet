package mini.wallet.monolith.model.snapshot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantProductSnapshot {
    private String merchantProductId;
    private String merchantProductName;
    private String price;
}
