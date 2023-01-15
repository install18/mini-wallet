package mini.wallet.monolith.model.snapshot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSnapshot {
    private String productId;
    private String productName;
    private String price;
    private String merchantProductId;
}
