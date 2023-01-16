package mini.wallet.monolith.controller;

import mini.wallet.monolith.model.request.RegisterRequest;
import mini.wallet.monolith.model.request.UserRegisterRequest;
import mini.wallet.monolith.model.request.WalletRegisterRequest;
import mini.wallet.monolith.model.response.RegisterResponse;
import mini.wallet.monolith.model.response.UserRegisterResponse;
import mini.wallet.monolith.model.response.WalletRegisterResponse;
import mini.wallet.monolith.service.UserService;
import mini.wallet.monolith.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    private final UserService userService;
    private final WalletService walletService;

    public RegisterController(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        UserRegisterRequest userRegisterRequest = buildUserRegisterRequest(registerRequest);
        UserRegisterResponse userRegisterResponse = userService.register(userRegisterRequest);

        WalletRegisterRequest walletRegisterRequest = buildWalletRegisterRequest(userRegisterResponse);
        WalletRegisterResponse walletRegisterResponse = walletService.register(walletRegisterRequest);


        return buildRegisterResponse(userRegisterResponse, walletRegisterResponse);
    }

    private UserRegisterRequest buildUserRegisterRequest(RegisterRequest registerRequest) {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();

        userRegisterRequest.setEmail(registerRequest.getEmail());
        userRegisterRequest.setAddress(registerRequest.getAddress());
        userRegisterRequest.setPassword(registerRequest.getPassword());
        userRegisterRequest.setFullName(registerRequest.getFullName());
        userRegisterRequest.setPhoneNumber(registerRequest.getPhoneNumber());

        return userRegisterRequest;
    }

    private WalletRegisterRequest buildWalletRegisterRequest(UserRegisterResponse userRegisterResponse) {
        WalletRegisterRequest walletRegisterRequest = new WalletRegisterRequest();

        walletRegisterRequest.setUserId(userRegisterResponse.getUser().getUserId());

        return walletRegisterRequest;
    }

    private RegisterResponse buildRegisterResponse(UserRegisterResponse userRegisterResponse,
                                                   WalletRegisterResponse walletRegisterResponse) {
        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setUser(userRegisterResponse.getUser());
        registerResponse.setWallet(walletRegisterResponse.getWallet());

        return registerResponse;
    }
}
