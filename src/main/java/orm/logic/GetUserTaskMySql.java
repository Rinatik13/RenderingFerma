package orm.logic;


import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.GetUserTask;
import java.util.List;

public class GetUserTaskMySql implements GetUserTask {

    @Override
    public List<UserTask> getUserTask(int user_id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserTask.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<UserTask> userTaskList = session.createQuery("from UserTask" + "where user_id=" + user_id)
                .getResultList();
        session.getTransaction().commit();
        return userTaskList;
    }
}
