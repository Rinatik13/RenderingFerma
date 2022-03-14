package logic.usermenu;

import orm.logic.AddNewUserMySql;
import orm.logic.GetUserInfoMySql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuAddNewUser {
    public void menuAddNewUser() throws IOException {
        System.out.println("Введите имя пользователя для регистрации: ");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String text = reader1.readLine();

        GetUserInfoMySql getUserInfoMySql = new GetUserInfoMySql();
        // ругается на строку ниже
        if (text.equals(getUserInfoMySql.user(text).getUser_name())){
            System.out.println("Данный пользователь сушествует." +
                    "\n Введите другое имя пользователя.");
            MenuUserName menuUserName = new MenuUserName();
            menuUserName.menuUserName();
        }
        else {
            AddNewUserMySql addNewUserMySql = new AddNewUserMySql();
            addNewUserMySql.addNew(text);
            System.out.println("Новый пользователь добавлен.");
            System.out.println("Вход в меню пользователя.");
            MenuUser menuUser = new MenuUser();
            menuUser.menuUser(getUserInfoMySql.user(text).getUser_id());
        }
    }
}
