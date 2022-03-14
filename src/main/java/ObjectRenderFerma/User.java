package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

// Основной класс "пользователь"
// хранит информацию имя, id и список задач данного пользователя

@Table (name = "users")
public class User {
    @Column(name = "user_name")
    String user_name;
    @Id
    int user_id;
    List <UserTask> userTasks;

    public User() {
    }

    public User(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_id=" + user_id +
                ", userTasks=" + userTasks +
                '}';
    }
}
