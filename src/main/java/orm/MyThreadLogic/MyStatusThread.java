package orm.MyThreadLogic;

import ObjectRenderFerma.HistoryTask;
import ObjectRenderFerma.UserTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

// реализация независимого потока который будет проверять статусы у заданий.

public class MyStatusThread implements Runnable {
    public void run() {

            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(UserTask.class)
                    .buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<UserTask> userTaskList =
                    session.createQuery("from UserTask").getResultList();
            session.getTransaction()
                    .commit();

            for (UserTask userTask1 : userTaskList) {
                if (userTask1.getStatus().equals("RENDERING")) {
                    try {
                        Thread.sleep(10000);
                        SessionFactory sessionFactory1 = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(UserTask.class)
                                .buildSessionFactory();

                        Session session1 = sessionFactory1.getCurrentSession();
                        session1.beginTransaction();
                        session1.createQuery("update UserTask set status = 'COMPLETE' " +
                                "where user_id = " + userTask1.getUser_id() + " and  task_id = " + userTask1.getTask_id()).executeUpdate();
                        session1.getTransaction()
                                .commit();
                        System.out.println("Изменение статуса задания." + userTask1.toString());

                        SessionFactory sessionFactory2 = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(HistoryTask.class)
                                .buildSessionFactory();

                        Session session2 = sessionFactory2.getCurrentSession();
                        Date date = new Date();
                        int id = userTask1.getTask_id();
                        HistoryTask historyTask = new HistoryTask(id, date.toString(),"COMPLETE",userTask1.getUser_id());
                        session2.beginTransaction();
                        session2.save(historyTask);
                        session2.getTransaction()
                                .commit();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
