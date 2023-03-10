package mini.wallet.monolith.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionResponse {
    private String productId;
    private String customerId;
    private String merchantId;
}
