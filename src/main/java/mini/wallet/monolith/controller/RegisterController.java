package mini.wallet.monolith.controller;

import mini.wallet.monolith.model.request.RegisterRequest;
import mini.wallet.monolith.model.response.RegisterResponse;
import mini.wallet.monolith.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
}
