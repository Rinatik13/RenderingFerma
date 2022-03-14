package ObjectRenderFerma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

// Основной класс "пользователь"
// хранит информацию имя, id и список задач данного пользователя
@Entity
@Table (name = "users")
public class User {
    @Column(name = "user_name")
    String user_name;
    @Id
    @Column(name = "user_id")
    int user_id;
//    @Column(name = "userTasks")
//    List <UserTask> userTasks;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

//    public List<UserTask> getUserTasks() {
//        return userTasks;
//    }
//
//    public void setUserTasks(List<UserTask> userTasks) {
//        this.userTasks = userTasks;
//    }

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
//                ", userTasks=" + userTasks +
                '}';
    }
}
