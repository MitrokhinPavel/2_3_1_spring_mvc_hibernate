package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
//    void createUsersTable();
    void saveUser(User user);
    List<User> getAllUsers();
}
