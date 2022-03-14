package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Данный класс содержит информацию по
// id истории
// id задачи за которой закреплена запись в истории
// дата внесения изменений
// какое событие произошло в задаче

@Entity
@Table(name = "historytask")
public class HistoryTask {
    @Id
    @Column(name = "historyTask_id")
    int historyTask_id;
    @Column(name = "task_id")
    int task_id;
    @Column(name = "user_id")
    int user_id;
    @Column(name = "data")
    String data;
    @Column(name = "eventTask")
    String eventTask;

    public HistoryTask() {
    }

    public HistoryTask(int task_id, String data, String eventTask, int user_id) {
        this.task_id = task_id;
        this.data = data;
        this.eventTask = eventTask;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getHistoryTask_id() {
        return historyTask_id;
    }

    public void setHistoryTask_id(int historyTask_id) {
        this.historyTask_id = historyTask_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEventTask() {
        return eventTask;
    }

    public void setEventTask(String eventTask) {
        this.eventTask = eventTask;
    }

    @Override
    public String toString() {
        return "HistoryTask{" +
                "historyTask_id=" + historyTask_id +
                ", task_id=" + task_id +
                ", user_id=" + user_id +
                ", data='" + data + '\'' +
                ", eventTask='" + eventTask + '\'' +
                '}';
    }
}
