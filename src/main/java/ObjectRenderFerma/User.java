package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

// Основной класс "пользователь"
// хранит информацию имя, id и список задач данного пользователя

@Table (name = "users")
public class User {
    @Column(name = "user_name")
    String user_name;
    @Id
    int user_id;
    ArrayList<UserTask> userTasks;

    public User() {
    }

    public User(String user_name) {
        this.user_name = user_name;
    }

}
