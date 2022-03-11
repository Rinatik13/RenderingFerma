package orm;

import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// В данном классе реализуем функционал hibernate
// реализуем интерфейс AddNewTask и его метод addNew
// данный метод получает id пользователя и добавляет
// новую задачу с привязкой с этому пользователю
// добавляем статус RENDERING
// добавляем в историю задач первую отметку "добавление задачи"

public class AddNEwTaskMySql implements AddNewTask{
    @Override
    public void addNew(int user_id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.config.xml")
                .addAnnotatedClass(UserTask.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        UserTask userTask = new UserTask(user_id);
        session.beginTransaction();
        session.save(userTask);
        session.getTransaction()
                .commit();
    }
}
