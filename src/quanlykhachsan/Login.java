package quanlykhachsan;

import quanlykhachsan.view.UserView;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static void menu() throws IOException {
        UserView userView = new UserView();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------MENU------------");
        System.out.println("|       1. Đăng nhập        |");
        System.out.println("|       2. Đăng ký          |");
        System.out.println("|       0. Thoát            |");
        System.out.println("|___________________________|");
        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    userView.doLogin();
                    break;
                }
                case 2: {
                    userView.doRegister();
                    menu();
                    break;
                }
            }
        } while (choice != 0);
    }
}
