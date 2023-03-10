package mini.wallet.monolith.service;

import lombok.AllArgsConstructor;
import mini.wallet.monolith.dal.dataobject.CustomerDO;
import mini.wallet.monolith.dal.repository.CustomerDAO;
import mini.wallet.monolith.helper.builder.CustomerBuilder;
import mini.wallet.monolith.model.Customer;
import mini.wallet.monolith.model.request.CustomerRegisterRequest;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.response.CustomerRegisterResponse;
import mini.wallet.monolith.model.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerRegisterResponse register(CustomerRegisterRequest customerRegisterRequest) {
        checkEmailAvailability(customerRegisterRequest.getEmail());

        CustomerDO customerDO = CustomerBuilder.buildCustomerDOFromCustomerRegisterRequest(customerRegisterRequest);
        customerDAO.save(customerDO);

        Customer customer = CustomerBuilder.buildCustomerFromCustomerDO(customerDO);

        CustomerRegisterResponse customerRegisterResponse = new CustomerRegisterResponse();
        customerRegisterResponse.setCustomer(customer);

        return customerRegisterResponse;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        CustomerDO customerDO = queryByEmail(loginRequest.getEmail());
        comparePassword(customerDO.getPassword(), loginRequest.getPassword());

        return buildLoginResponse(customerDO);
    }

    private LoginResponse buildLoginResponse(CustomerDO customerDO){
        LoginResponse loginResponse = new LoginResponse();

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDO, customer);

        return loginResponse;
    }

    private void comparePassword(String customerPassword, String inputtedPassword) {
        boolean isEqual = customerPassword.contentEquals(inputtedPassword);
        Assert.isTrue(isEqual, "Password doesn't match");
    }

    private CustomerDO queryByEmail(String email) {
        Optional<CustomerDO> customerDOOptional = customerDAO.queryByEmail(email);
        Assert.isTrue(customerDOOptional.isPresent(), "Email doesn't exist");

        return customerDOOptional.get();
    }

    private void checkEmailAvailability(String email) {
        Optional<CustomerDO> customerDOOptional = customerDAO.queryByEmail(email);
        Assert.isTrue(customerDOOptional.isEmpty(), "Email taken");
    }
}
