package quanlykhachsan.menuRun;

import quanlykhachsan.controller.UserView;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    static Scanner scanner = new Scanner(System.in);
    public static void menu() throws IOException {
        UserView userView = new UserView();
        System.out.println("                                                      ----*★*Merry*★*---_MENU đăng nhập---★*Christmas*★*--");
        System.out.println("                                                      ★                     1. Đăng nhập                  ★");
        System.out.println("                                                      ★                     2. Đăng ký                    ★");
        System.out.println("                                                      ★                     0. Thoát                      ★");
        System.out.println("                                                      ★___________________________________________________★");
        System.out.println("                                                                        ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();
            if (choice >= 1 && choice <= 2) {
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
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
    }

    private static int checkChoice() {
        boolean checkChoice;
        int choice = 0;
        do {
            checkChoice = true;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkChoice = false;
                System.err.println("---Mời nhập lại số có trong menu!!!---");
            }
        }while (!checkChoice);
        return choice;
    }
}
