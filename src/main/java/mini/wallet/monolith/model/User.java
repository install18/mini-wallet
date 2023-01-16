package mini.wallet.monolith.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
}
