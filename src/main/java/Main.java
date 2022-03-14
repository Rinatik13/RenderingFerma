
import orm.interfaces.GetUserInfo;
import orm.logic.AddNewUserMySql;
import orm.logic.GetUserInfoMySql;
import orm.usermenu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();


        // реализуем основные команды которые вводит пользователь

        // Добавление стартовых команд
        System.out.println("Введите \"name\" для входа под вашим именем \n"+
                "или введите \" newuser \" для добавление нового пользователя");

        // Добавление нового пользователя
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textCommand = reader.readLine();
        if (textCommand.equals("name")){
            System.out.println("Введите имя пользователя для входа: ");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String text = reader1.readLine();
            GetUserInfo userInfo = new GetUserInfoMySql(text);
            userInfo.toString();
        }
        else if (textCommand.equals("newuser")){
            System.out.println("Введите имя подьзователя для регистрации");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String text = reader1.readLine();
            AddNewUserMySql newUser = new AddNewUserMySql();
            newUser.addNew(text);
        }
    }
}