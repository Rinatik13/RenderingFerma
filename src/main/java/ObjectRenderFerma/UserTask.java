package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

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
    ArrayList <HistoryTask> historyTasks;

    public UserTask() {
    }



    public UserTask(int user_id) {
        this.user_id = user_id;
        this.status = "RENDERING";
    }
}
