package mini.wallet.monolith.controller;


import lombok.AllArgsConstructor;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import mini.wallet.monolith.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    private final CustomerService customerService;

    public LoginResponse login(LoginRequest loginRequest) {
        return customerService.login(loginRequest);
    }
}
