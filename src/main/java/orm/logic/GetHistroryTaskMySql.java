package orm.logic;

import ObjectRenderFerma.HistoryTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import orm.interfaces.GetHistoryTask;
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
                ("from HistoryTask"+ "where task_id="+task_id)
                .getResultList();
        session.getTransaction().commit();

        return historyTaskList;
    }
}
