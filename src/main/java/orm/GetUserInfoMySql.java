package orm;

import ObjectRenderFerma.User;

// реализуем интерфейс GetUserInfo и его метод user
// реализуем функционал Hibernate
// метод получает имя пользователя и выдаёт всю информацию о неём с БД

public class GetUserInfoMySql implements GetUserInfo{

    @Override
    public User user(String user_name) {
        return null;
    }
}
