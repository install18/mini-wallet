package mini.wallet.monolith.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mini.wallet.monolith.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {
    private User user;
}
