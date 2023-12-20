package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    User readUser(long id);

    User deleteUser(long id);
}