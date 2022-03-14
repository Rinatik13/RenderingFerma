package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

// Данный класс содержит информацию по
// id истории
// id задачи за которой закреплена запись в истории
// дата внесения изменений
// какое событие произошло в задаче

@Table(name = "historyTask")
public class HistoryTask {
    @Id
    int historyTask_id;
    @Column(name = "task_id")
    int task_id;
    @Column(name = "data")
    String data;
    @Column(name = "eventTask")
    String eventTask;

    public HistoryTask() {
    }

    public HistoryTask(int task_id, String data, String eventTask) {
        this.task_id = task_id;
        this.data = data;
        this.eventTask = eventTask;
    }

    @Override
    public String toString() {
        return "HistoryTask{" +
                "historyTask_id=" + historyTask_id +
                ", task_id=" + task_id +
                ", data='" + data + '\'' +
                ", eventTask='" + eventTask + '\'' +
                '}';
    }
}
