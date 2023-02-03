package mini.wallet.monolith.helper.builder;

import mini.wallet.monolith.dal.dataobject.CustomerDO;
import mini.wallet.monolith.model.Customer;
import mini.wallet.monolith.model.request.CustomerRegisterRequest;

import java.util.UUID;

public class CustomerBuilder {
    public static CustomerDO buildCustomerDOFromCustomerRegisterRequest(CustomerRegisterRequest customerRegisterRequest) {
        CustomerDO customerDO = new CustomerDO();

        customerDO.setCustomerId(UUID.randomUUID().toString());
        customerDO.setEmail(customerRegisterRequest.getEmail());
        customerDO.setPassword(customerRegisterRequest.getPassword());
        customerDO.setAddress(customerRegisterRequest.getAddress());
        customerDO.setFullName(customerRegisterRequest.getFullName());
        customerDO.setPhoneNumber(customerRegisterRequest.getPhoneNumber());

        return customerDO;
    }

    public static Customer buildCustomerFromCustomerDO(CustomerDO customerDO) {
        Customer customer = new Customer();

        customer.setCustomerId(customerDO.getCustomerId());
        customer.setEmail(customerDO.getEmail());
        customer.setAddress(customerDO.getAddress());
        customer.setFullName(customerDO.getFullName());
        customer.setPhoneNumber(customerDO.getPhoneNumber());

        return customer;
    }
}
