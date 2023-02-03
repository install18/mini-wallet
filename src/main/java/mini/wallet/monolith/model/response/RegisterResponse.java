package mini.wallet.monolith.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mini.wallet.monolith.model.Customer;
import mini.wallet.monolith.model.Wallet;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private Customer customer;
    private Wallet wallet;
}
