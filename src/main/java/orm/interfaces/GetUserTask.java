package orm.interfaces;

import ObjectRenderFerma.UserTask;

import java.util.List;

public interface GetUserTask {
    List <UserTask> getUserTask (int user_id);
}
