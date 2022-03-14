package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

// Данный класс содержит информацию
// id пользователя за кем эти задания закрепляются
// id самой задачи
// статус задачи на данный момент
// список истории внесения изменений в задачи

// нужно реализовать метод по добавлению информации в историю задачи
// при создании задачи должна ставится отметка о создании

@Table(name = "usertasks")
public class UserTask {
    @Column(name = "user_id")
    int user_id;
    @Id
    int task_id;
    @Column(name = "status")
    String status;
    List <HistoryTask> historyTasks;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<HistoryTask> getHistoryTasks() {
        return historyTasks;
    }

    public void setHistoryTasks(List<HistoryTask> historyTasks) {
        this.historyTasks = historyTasks;
    }

    public UserTask() {
    }



    public UserTask(int user_id) {
        this.user_id = user_id;
        this.status = "RENDERING";
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "user_id=" + user_id +
                ", task_id=" + task_id +
                ", status='" + status + '\'' +
                '}';
    }
}
