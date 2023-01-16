package mini.wallet.monolith.service;

import mini.wallet.monolith.builder.UserBuilder;
import mini.wallet.monolith.dal.dataobject.UserDO;
import mini.wallet.monolith.dal.repository.UserRepository;
import mini.wallet.monolith.model.User;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.request.UserRegisterRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import mini.wallet.monolith.model.response.UserRegisterResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        checkEmailAvailability(userRegisterRequest.getEmail());

        UserDO userDO = UserBuilder.buildUserDOFromUserRegisterRequest(userRegisterRequest);
        userRepository.save(userDO);

        User user = UserBuilder.buildUserFromUserDO(userDO);

        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setUser(user);

        return userRegisterResponse;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        UserDO userDO = queryByEmail(loginRequest.getEmail());
        comparePassword(userDO.getPassword(), loginRequest.getPassword());

        return loginResponse;
    }

    private void comparePassword(String userPassword, String inputtedPassword) {
        boolean isEqual = userPassword.contentEquals(inputtedPassword);
        Assert.isTrue(isEqual, "Password doesn't match");
    }

    private UserDO queryByEmail(String email) {
        Optional<UserDO> userDOOptional = userRepository.queryByEmail(email);
        Assert.isTrue(userDOOptional.isPresent(), "Email doesn't exist");

        return userDOOptional.get();
    }

    private void checkEmailAvailability(String email) {
        Optional<UserDO> userDOOptional = userRepository.queryByEmail(email);
        Assert.isTrue(userDOOptional.isEmpty(), "Email taken");
    }
}
