package orm.logic;

import ObjectRenderFerma.HistoryTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.GetHistoryTask;

import java.util.ArrayList;
import java.util.List;

public class GetHistroryTaskMySql implements GetHistoryTask {

    @Override
    public List <HistoryTask> getHistoryTask(int task_id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(HistoryTask.class)
                .buildSessionFactory();

        Session session  = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<HistoryTask> historyTaskList = session.createQuery
                ("from HistoryTask")
                .getResultList();
        session.getTransaction().commit();
        List<HistoryTask> historyTasks = new ArrayList<>();
        for (HistoryTask historyTask : historyTaskList){
            if (historyTask.getTask_id()==task_id){
                historyTasks.add(historyTask);
            }
        }

        return historyTasks;
    }
}
