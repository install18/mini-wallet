package mini.wallet.monolith.api;


import lombok.AllArgsConstructor;
import mini.wallet.monolith.controller.RegisterController;
import mini.wallet.monolith.model.request.RegisterRequest;
import mini.wallet.monolith.model.response.RegisterResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/register")
public class RegisterAPI {
    private final RegisterController registerController;

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return registerController.register(registerRequest);
    }
}
