package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (user.getId() == null) {
            createUser(user);
        } else {
            if (user.getId() != null) {
                updateUser(user);
            } else {
                throw new IllegalArgumentException("User ID cannot be null");
            }
        }
    }

    private void createUser(User user) {
        userDao.createUser(user);
    }
    private void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public User readUser(long id) {
        return userDao.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDao.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}