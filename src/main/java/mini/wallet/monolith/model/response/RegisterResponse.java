package mini.wallet.monolith.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mini.wallet.monolith.model.User;
import mini.wallet.monolith.model.Wallet;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private User user;
    private Wallet wallet;
}
