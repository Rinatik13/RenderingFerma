
import logic.usermenu.MenuAddNewUser;
import logic.usermenu.MenuUserName;
import orm.MyThreadLogic.MyMainThread;
import orm.MyThreadLogic.MyStatusThread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MyMainThread myMainThread = new MyMainThread();
        MyStatusThread myStatusThread = new MyStatusThread();

        Thread threadMain = new Thread(myMainThread);
        Thread threadStatus = new Thread(myStatusThread);

        threadMain.start();
        threadStatus.start();
        threadMain.stop();
        threadStatus.stop();


    }
}