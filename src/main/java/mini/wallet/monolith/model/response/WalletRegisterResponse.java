package mini.wallet.monolith.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mini.wallet.monolith.model.Wallet;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletRegisterResponse {
    private Wallet wallet;
}
