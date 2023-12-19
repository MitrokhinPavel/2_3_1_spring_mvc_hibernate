package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

//    @Override
//    public void createUsersTable() {
//        // код
//    }
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