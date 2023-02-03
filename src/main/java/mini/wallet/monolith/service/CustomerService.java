package mini.wallet.monolith.service;

import jakarta.transaction.Transactional;
import mini.wallet.monolith.dal.dataobject.CustomerDO;
import mini.wallet.monolith.dal.repository.CustomerRepository;
import mini.wallet.monolith.helper.builder.CustomerBuilder;
import mini.wallet.monolith.model.Customer;
import mini.wallet.monolith.model.request.CustomerRegisterRequest;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.CustomerRegisterResponse;
import mini.wallet.monolith.model.response.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerRegisterResponse register(CustomerRegisterRequest customerRegisterRequest) {
        checkEmailAvailability(customerRegisterRequest.getEmail());

        CustomerDO customerDO = CustomerBuilder.buildCustomerDOFromCustomerRegisterRequest(customerRegisterRequest);
        customerRepository.save(customerDO);

        Customer customer = CustomerBuilder.buildCustomerFromCustomerDO(customerDO);

        CustomerRegisterResponse customerRegisterResponse = new CustomerRegisterResponse();
        customerRegisterResponse.setCustomer(customer);

        return customerRegisterResponse;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        CustomerDO customerDO = queryByEmail(loginRequest.getEmail());
        comparePassword(customerDO.getPassword(), loginRequest.getPassword());

        return loginResponse;
    }

    private void comparePassword(String customerPassword, String inputtedPassword) {
        boolean isEqual = customerPassword.contentEquals(inputtedPassword);
        Assert.isTrue(isEqual, "Password doesn't match");
    }

    private CustomerDO queryByEmail(String email) {
        Optional<CustomerDO> customerDOOptional = customerRepository.queryByEmail(email);
        Assert.isTrue(customerDOOptional.isPresent(), "Email doesn't exist");

        return customerDOOptional.get();
    }

    private void checkEmailAvailability(String email) {
        Optional<CustomerDO> customerDOOptional = customerRepository.queryByEmail(email);
        Assert.isTrue(customerDOOptional.isEmpty(), "Email taken");
    }
}
