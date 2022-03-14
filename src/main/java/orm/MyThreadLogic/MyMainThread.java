package orm.MyThreadLogic;

import logic.usermenu.MenuAddNewUser;
import logic.usermenu.MenuUserName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMainThread implements Runnable{

    @Override
    public void run() {

        System.out.println("Введите \"name\" для входа под вашим именем, \n"+
                "введите \"newuser \" для добавление нового пользователя, \n" +
                "введите \"exit\" для выхода.");

        // Добавление нового пользователя
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textCommand = null;
        try {
            textCommand = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (textCommand){
            case "name":
                MenuUserName menuUserName = new MenuUserName();
                try {
                    menuUserName.menuUserName();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "newuser":
                MenuAddNewUser menuAddNewUser = new MenuAddNewUser();
                try {
                    menuAddNewUser.menuAddNewUser();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "exit":
                break;
            default:
                System.out.println("Неправильно введена команда, повторите попытку.");
        }
    }
}
