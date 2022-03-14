package orm.interfaces;

import ObjectRenderFerma.HistoryTask;
import java.util.List;

// интерфейс получения истории заданий

public interface GetHistoryTask {
    List <HistoryTask> getHistoryTask(int task_id);
}
