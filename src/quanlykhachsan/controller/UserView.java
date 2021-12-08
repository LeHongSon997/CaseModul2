package quanlykhachsan.controller;

import quanlykhachsan.menuRun.Login;
import quanlykhachsan.menuRun.Main;
import quanlykhachsan.model.User;
import quanlykhachsan.manage.ManageUser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    ManageUser manageUser = new ManageUser();
    List<User> userList = manageUser.findAll();

    public UserView() throws IOException {
    }

    public void showUser() throws IOException {
        for (User u: userList) {
            System.out.println(u);
        }
        System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void editUser() throws IOException {
        while (true) {
            for (User u: userList) {
                System.out.println(u);
            }
            User user = getUser();
            manageUser.edit(user.getId(),user);
            System.out.println("----Edit success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    private User getUser() throws IOException {
        int id = checkId();
        String username = mail();
        String password = password();
        String role = "";
        do {
            System.out.println("-----Nhập role(admin/user): -----");
            role = scanner.nextLine();
        } while (!role.equals("admin") && !role.equals("user"));
        return new User(id, username, password, role);
    }

    public void deleteUser() throws IOException {
        while (true) {
            for (User u: userList) {
                System.out.println(u);
            }
            int id = checkId();
            manageUser.delete(id);
            System.out.println("----Delete success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public User isLogin(User user) {
        for (User user1 : userList) {
            if (user.getUsername().equals(user1.getUsername())
                    && user.getPassword().equals(user1.getPassword())){
                return user1;
            }
        }
        return null;
    }

    public void doRegister() throws IOException {
            System.out.println("------Tạo tài khoản mới------");
            User user = getUser();
        for (User user1 : userList) {
            if (user.getUsername().equals(user1.getUsername())){
                System.err.println("---Tên tài khoản đã tồn tại---");
            } else {
                manageUser.save(user);
            }
            break;
        }
    }

    public void doLogin() throws IOException {
        while (true) {
            System.out.println("Đăng nhập......");
            String username = mail();
            String password = password();
            User userLogin = new User(username, password);
            if (isLogin(userLogin) != null) {
                User user = isLogin(userLogin);
                if (user.getRole().equals("admin")) {
                    new Main();
                } else {
                    Main.bookRoom();
                }
                break;
            } else {
                System.err.println("---Sai tài khoản hoặc mật khẩu!!!---");
            }
        }
    }

    public String mail() throws IOException {
        String mail = "";
        while (true) {
            System.out.println("--------Nhập vào mail: ...@gmail...------");
            mail = scanner.nextLine();
            Pattern m = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,5}(\\.[a-zA-Z]+){1,3}$");
            if (m.matcher(mail).find()) {
                System.out.println("Mail: " + mail);
                break;
            } else {
                System.err.println("-----Nhập lại mail Or Enter QUIT to back MENU Login---- ");
                String back = scanner.next();
                if (back.equalsIgnoreCase("quit")) {
                    Login.menu();
                }
            }
        }
        return mail;
    }

    public String password() throws IOException {
        String pass = "";
        while (true) {
            System.out.println("-----Nhập vào pass: -----");
            pass = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,8}$");
            if (p.matcher(pass).find()) {
                System.out.println("------Hello my friend----");
                break;
            } else {
                System.err.println("-----Nhập lại pass Or Enter QUIT to back MENU Login---- ");
                String back = scanner.next();
                if (back.equalsIgnoreCase("quit")) {
                    Login.menu();
                }
            }
        }
        return pass;
    }

    private int checkId() {
        boolean checkId;
        int id = 0;
        do {
            System.out.println("----Nhập id muốn thao tác: ----");
            checkId = true;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkId = false;
                System.err.println("Id phải là số!!!");
            }
        }while (!checkId);
        return id;
    }
}
