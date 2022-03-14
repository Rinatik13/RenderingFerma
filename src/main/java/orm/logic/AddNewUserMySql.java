package orm.logic;

import ObjectRenderFerma.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.AddNewUser;

// в данном классе реализуем функционал hibernate
// используем интерфейс AddNewUser и наследуем его метод
// в методе addNew реализуем добавление нового
// пользователя в БД
// используем конструктор класса User для присвоения имени пользователю

public class AddNewUserMySql implements AddNewUser {
    @Override
    public void addNew(String user_name) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        User user = new User(user_name);
        session.beginTransaction();
        session.save(user);
        session.getTransaction()
                .commit();
    }
}
