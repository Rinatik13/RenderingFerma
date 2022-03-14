package orm.logic;

import ObjectRenderFerma.HistoryTask;
import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.AddNewTask;

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
        System.out.println("Создание задачи");
        Session session = sessionFactory.getCurrentSession();
        UserTask userTask = new UserTask(user_id);
        Date date = new Date();
        System.out.println(date.toString());
        session.beginTransaction();
        session.save(userTask);
        int id = session.createQuery("from UserTask").getResultList().size();
        HistoryTask historyTask = new HistoryTask(id, date.toString(),"RENDERING",user_id);
        System.out.println(userTask.toString());
        session.getTransaction()
                .commit();
        System.out.println("Создания истории задачи");

        SessionFactory sessionFactory1 = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(HistoryTask.class)
                .buildSessionFactory();
        Session session1 = sessionFactory1.getCurrentSession();
        session1.beginTransaction();
        session1.save(historyTask);
        session1.getTransaction()
                .commit();
    }
}
