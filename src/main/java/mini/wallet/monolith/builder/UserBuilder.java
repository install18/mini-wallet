package mini.wallet.monolith.builder;

import mini.wallet.monolith.dal.dataobject.UserDO;
import mini.wallet.monolith.model.User;
import mini.wallet.monolith.model.request.UserRegisterRequest;

import java.util.UUID;

public class UserBuilder {
    public static UserDO buildUserDOFromUserRegisterRequest(UserRegisterRequest userRegisterRequest) {
        UserDO userDO = new UserDO();

        userDO.setUserId(UUID.randomUUID().toString());
        userDO.setEmail(userRegisterRequest.getEmail());
        userDO.setPassword(userRegisterRequest.getPassword());
        userDO.setAddress(userRegisterRequest.getAddress());
        userDO.setFullName(userRegisterRequest.getFullName());
        userDO.setPhoneNumber(userRegisterRequest.getPhoneNumber());

        return userDO;
    }

    public static User buildUserFromUserDO(UserDO userDO) {
        User user = new User();

        user.setUserId(userDO.getUserId());
        user.setEmail(userDO.getEmail());
        user.setAddress(userDO.getAddress());
        user.setFullName(userDO.getFullName());
        user.setPhoneNumber(userDO.getPhoneNumber());

        return user;
    }
}
