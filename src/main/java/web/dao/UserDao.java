package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
//    void createUsersTable();
    void saveUser(User user);
    List<User> getAllUsers();
}