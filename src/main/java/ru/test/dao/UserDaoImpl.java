package ru.test.dao;

        import org.hibernate.SessionFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
        import ru.test.model.User;

        import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().createQuery("from User where id = '" + id + "'", User.class).getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
