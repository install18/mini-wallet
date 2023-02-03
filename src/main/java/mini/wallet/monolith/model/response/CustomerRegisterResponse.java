package mini.wallet.monolith.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mini.wallet.monolith.model.Customer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterResponse {
    private Customer customer;
}
