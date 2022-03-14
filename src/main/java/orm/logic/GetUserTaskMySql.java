package orm.logic;


import ObjectRenderFerma.HistoryTask;
import ObjectRenderFerma.User;
import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.GetUserTask;

import java.util.ArrayList;
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
        List<UserTask> userTaskList = session.createQuery("from UserTask")
                .getResultList();
        session.getTransaction().commit();
        List<UserTask> userTasks = new ArrayList<>();
        for (UserTask userTask : userTaskList){
            if (userTask.getUser_id()==user_id){
                userTasks.add(userTask);
            }
        }
        return userTasks;
    }

    public List<UserTask> getAllUserTask (){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserTask.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<UserTask> userTaskList = session.createQuery("from UserTask")
                .getResultList();
        session.getTransaction().commit();
        return userTaskList;
    }
}
