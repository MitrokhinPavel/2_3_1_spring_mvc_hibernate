package web.dao;

import web.model.User;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return userList;
    }
}