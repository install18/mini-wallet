package mini.wallet.monolith.controller;

import mini.wallet.monolith.model.request.CustomerRegisterRequest;
import mini.wallet.monolith.model.request.RegisterRequest;
import mini.wallet.monolith.model.request.WalletRegisterRequest;
import mini.wallet.monolith.model.response.CustomerRegisterResponse;
import mini.wallet.monolith.model.response.RegisterResponse;
import mini.wallet.monolith.model.response.WalletRegisterResponse;
import mini.wallet.monolith.service.CustomerService;
import mini.wallet.monolith.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    private final CustomerService customerService;
    private final WalletService walletService;

    public RegisterController(CustomerService customerService, WalletService walletService) {
        this.customerService = customerService;
        this.walletService = walletService;
    }

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        CustomerRegisterRequest customerRegisterRequest = buildCustomerRegisterRequest(registerRequest);
        CustomerRegisterResponse customerRegisterResponse = customerService.register(customerRegisterRequest);

        WalletRegisterRequest walletRegisterRequest = buildWalletRegisterRequest(customerRegisterResponse);
        WalletRegisterResponse walletRegisterResponse = walletService.register(walletRegisterRequest);


        return buildRegisterResponse(customerRegisterResponse, walletRegisterResponse);
    }

    private CustomerRegisterRequest buildCustomerRegisterRequest(RegisterRequest registerRequest) {
        CustomerRegisterRequest customerRegisterRequest = new CustomerRegisterRequest();

        customerRegisterRequest.setEmail(registerRequest.getEmail());
        customerRegisterRequest.setAddress(registerRequest.getAddress());
        customerRegisterRequest.setPassword(registerRequest.getPassword());
        customerRegisterRequest.setFullName(registerRequest.getFullName());
        customerRegisterRequest.setPhoneNumber(registerRequest.getPhoneNumber());

        return customerRegisterRequest;
    }

    private WalletRegisterRequest buildWalletRegisterRequest(CustomerRegisterResponse customerRegisterResponse) {
        WalletRegisterRequest walletRegisterRequest = new WalletRegisterRequest();

        walletRegisterRequest.setCustomerId(customerRegisterResponse.getCustomer().getCustomerId());

        return walletRegisterRequest;
    }

    private RegisterResponse buildRegisterResponse(CustomerRegisterResponse customerRegisterResponse,
                                                   WalletRegisterResponse walletRegisterResponse) {
        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setCustomer(customerRegisterResponse.getCustomer());
        registerResponse.setWallet(walletRegisterResponse.getWallet());

        return registerResponse;
    }
}
