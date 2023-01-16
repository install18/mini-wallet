package mini.wallet.monolith.service.user;

import mini.wallet.monolith.builder.UserBuilder;
import mini.wallet.monolith.dal.dataobject.UserDO;
import mini.wallet.monolith.dal.repository.UserRepository;
import mini.wallet.monolith.model.User;
import mini.wallet.monolith.model.request.LoginRequest;
import mini.wallet.monolith.model.request.RegisterRequest;
import mini.wallet.monolith.model.response.LoginResponse;
import mini.wallet.monolith.model.response.RegisterResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();

        checkEmailAvailability(registerRequest.getEmail());
        UserDO userDO = insertUser(registerRequest);
        User user = UserBuilder.buildUserFromUserDO(userDO);

        registerResponse.setUser(user);

        return registerResponse;
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

    private UserDO insertUser(RegisterRequest registerRequest) {
        UserDO userDO = UserBuilder.buildUserDOFromRegisterRequest(registerRequest);
        return userRepository.save(userDO);
    }
}
