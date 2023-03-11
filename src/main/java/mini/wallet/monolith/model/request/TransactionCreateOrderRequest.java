package mini.wallet.monolith.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreateOrderRequest {
    private String productId;
    private String customerId;
    private String merchantId;
}
