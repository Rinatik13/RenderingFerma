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
}
