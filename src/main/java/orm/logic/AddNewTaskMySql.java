package orm.logic;

import ObjectRenderFerma.HistoryTask;
import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.AddNewTask;

import javax.xml.crypto.Data;
import java.util.Date;

// В данном классе реализуем функционал hibernate
// реализуем интерфейс AddNewTask и его метод addNew
// данный метод получает id пользователя и добавляет
// новую задачу с привязкой с этому пользователю
// добавляем статус RENDERING
// добавляем в историю задач первую отметку "добавление задачи"

public class AddNewTaskMySql implements AddNewTask {
    @Override
    public void addNew(int user_id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserTask.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        UserTask userTask = new UserTask(user_id);
        Date date = new Date();
        session.beginTransaction();
        session.save(userTask);
        HistoryTask historyTask = new HistoryTask(userTask.getTask_id(),date.toString(),"RENDERING");
        session.save(historyTask);
        session.getTransaction()
                .commit();
    }
}
