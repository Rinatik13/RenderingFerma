package logic.usermenu;

import ObjectRenderFerma.User;
import ObjectRenderFerma.UserTask;
import orm.logic.AddNewTaskMySql;
import orm.logic.GetHistroryTaskMySql;
import orm.logic.GetUserTaskMySql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MenuUser {
    public void menuUser(int user_id) throws IOException {
        System.out.println("Введите команду для управления доступными функциями: " +
                "\n \"addtask\" - добавление новой задачи." +
                "\n \"getinfotask\" - вывод информации по задачам." +
                "\n \"gettaskhistory\" - вывод по истории изменений в задаче." +
                "\n \"exit\" - выход.");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String text = reader1.readLine();
        switch (text){
            case "addtask":
                AddNewTaskMySql addNewTaskMySql = new AddNewTaskMySql();
                User user = new User();
                addNewTaskMySql.addNew(user_id);
                System.out.println("Здача добавленна!");
                menuUser(user_id);
                break;
            case "getinfotask":
                GetUserTaskMySql getUserTaskMySql = new GetUserTaskMySql();
                List<UserTask> userTaskList = getUserTaskMySql.getUserTask(user_id);
                for(UserTask userTask:userTaskList ){
                    System.out.println(userTask.toString());
                }
                menuUser(user_id);
                break;
            case "gettaskhistory":
                System.out.println("Введите номер задачи: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int num = Integer.parseInt(reader.readLine());
                GetHistroryTaskMySql getHistroryTaskMySql = new GetHistroryTaskMySql();
                System.out.println(getHistroryTaskMySql.getHistoryTask(num));
                menuUser(user_id);
                break;
            case "exit":
                break;
        }
    }

}
