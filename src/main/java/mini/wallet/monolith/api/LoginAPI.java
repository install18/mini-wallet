package mini.wallet.monolith.api;


import lombok.AllArgsConstructor;
import mini.wallet.monolith.controller.LoginController;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/login")
public class LoginAPI {
    private final LoginController loginController;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginController.login(loginRequest);
    }
}
