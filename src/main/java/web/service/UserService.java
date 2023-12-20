package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createOrUpdateUser(User user);
    List<User> getAllUsers();
    User readUser(long id);

    User deleteUser(long parseUnsignedInt);
}
