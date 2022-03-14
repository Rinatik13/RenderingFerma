package logic.usermenu;

import ObjectRenderFerma.User;
import orm.logic.GetUserInfoMySql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuUserName {
    public void menuUserName() throws IOException {
        System.out.println("Введите имя пользователя для входа: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        GetUserInfoMySql getUserInfoMySql = new GetUserInfoMySql();
        if (text.equals(getUserInfoMySql.user(text).getUser_name())){
            System.out.println("Вход в меню пользователя.");
            MenuUser menuUser = new MenuUser();
            menuUser.menuUser(getUserInfoMySql.user(text).getUser_id());
        }
        else {
            System.out.println("Пользователь отсутствует." +
                    "\n Введиье \"name\" для повторного ввода логина или" +
                    "\n введите \"exit\" для выхода в начальное меню." );
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String text1 = reader1.readLine();
            switch (text1){
                case "name":
                    MenuUserName menuUserName = new MenuUserName();
                    menuUserName.menuUserName();
                    break;
                case "exit":
                    break;
            }
        }
    }
}
