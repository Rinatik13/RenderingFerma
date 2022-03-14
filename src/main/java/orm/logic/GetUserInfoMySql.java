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

    public GetUserInfoMySql() {
    }

    @Override
    public User user(String user_name) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println(" Начало обработки");
        // необходимо протестировать метод выбоки конкретных пользователей по нику
        List<User> userList = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        User myUser = new User();
        for (User user:userList){
            if (user.getUser_name().equals(user_name)){
                myUser = user;
            }
        }
        sessionFactory.close();
        System.out.println("Полученние данных о пользователе!");
        System.out.println(myUser.toString());
        return myUser;

    }
}
