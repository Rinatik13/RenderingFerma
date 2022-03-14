package orm.logic;

import ObjectRenderFerma.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.GetUserInfo;
import java.util.List;

// реализуем интерфейс GetUserInfo и его метод user
// реализуем функционал Hibernate
// метод получает имя пользователя и выдаёт всю информацию о неём с БД

public class GetUserInfoMySql implements GetUserInfo {

    public GetUserInfoMySql(String username) {
    }

    @Override
    public User user(String user_name) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        // необходимо протестировать метод выбоки конкретных пользователей по нику
        List<User> userArrayList =
                session.createQuery("from User"+"where user_name=" + user_name)
                        .getResultList();
        User user = userArrayList.get(0);
        return user;
    }
}
