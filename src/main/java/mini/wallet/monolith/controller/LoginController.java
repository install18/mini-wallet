package mini.wallet.monolith.controller;


import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import mini.wallet.monolith.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {
    private final CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return customerService.login(loginRequest);
    }
}
