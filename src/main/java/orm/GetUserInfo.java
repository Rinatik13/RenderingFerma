package orm;

import ObjectRenderFerma.User;

// интерфейс по получению информации о пользователе

public interface GetUserInfo {
    User user (String user_name);
}
