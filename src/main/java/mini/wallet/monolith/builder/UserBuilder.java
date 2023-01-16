package mini.wallet.monolith.builder;

import mini.wallet.monolith.dal.dataobject.UserDO;
import mini.wallet.monolith.model.User;
import mini.wallet.monolith.model.request.RegisterRequest;

import java.util.UUID;

public class UserBuilder {
    public static UserDO buildUserDOFromRegisterRequest(RegisterRequest registerRequest) {
        UserDO userDO = new UserDO();

        userDO.setUserId(UUID.randomUUID().toString());
        userDO.setEmail(registerRequest.getEmail());
        userDO.setPassword(registerRequest.getPassword());
        userDO.setAddress(registerRequest.getAddress());
        userDO.setFullName(registerRequest.getFullName());
        userDO.setPhoneNumber(registerRequest.getPhoneNumber());

        return userDO;
    }

    public static User buildUserFromUserDO(UserDO userDO) {
        User user = new User();

        user.setEmail(userDO.getEmail());
        user.setAddress(userDO.getAddress());
        user.setFullName(userDO.getFullName());
        user.setPhoneNumber(userDO.getPhoneNumber());

        return user;
    }
}
