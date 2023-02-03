package mini.wallet.monolith.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
