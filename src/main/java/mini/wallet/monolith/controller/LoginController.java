package mini.wallet.monolith.controller;


import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import mini.wallet.monolith.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public LoginResponse register(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
