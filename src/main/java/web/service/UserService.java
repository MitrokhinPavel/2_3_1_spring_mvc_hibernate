package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    User readUser(long id);
    User deleteUser(long parseUnsignedInt);
}
