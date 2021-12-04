package quanlykhachsan.view;

import quanlykhachsan.Main;
import quanlykhachsan.controller.UserController;
import quanlykhachsan.model.User;
import quanlykhachsan.sevice.ManageUser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    ManageUser manageUser = new ManageUser();
    UserController userController = new UserController();
    List<User> userList = userController.showUser();

    public UserView() throws IOException {
    }

    public void showUser() throws IOException {
        System.out.println(userList);
        System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void addNewUser() throws IOException {
        while (true) {
            int id;
            if (userList.size() == 0) {
                id = 1;
            } else {
                id = userList.get(userList.size() - 1).getId() + 1;
            }
            User user = getUser(id);
            userController.addUser(user);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void editUser() throws IOException {
        while (true) {
            int index = manageUser.findById();
            User user = getUser(index);
            userController.editUser(index,user);
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void deleteUser() throws IOException {
        while (true) {
            userController.deleteUser();
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    private User getUser(int id) throws IOException {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the password: ");
        String password = scanner.nextLine();
        System.out.println("Enter the role: ");
        String role = scanner.nextLine();
        return new User(id, name, password, role);
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
            System.out.println("Tạo tài khoản mới");
            System.out.println("Nhập id:");
            int id = Integer.parseInt(scanner.nextLine());
            String username = mail();
            String password = password();
            String role = "";
            do {
                System.out.println("Nhập role(admin/user):");
                role = scanner.nextLine();
            } while (!role.equals("admin") && !role.equals("user"));
            User user = new User(id, username, password, role);
            userController.addUser(user);
        }

    public void doLogin() throws IOException {
        System.out.println("Đăng nhập....");
        String username = mail();
        String password = password();
        User userLogin = new User(username, password);
        if (isLogin(userLogin) != null) {
            User user = isLogin(userLogin);
            if (user.getRole().equals("admin")) {
                new Main();
            }else {
                Main.bookRoom();
            }
        } else {
            System.err.println("Sai tài khoản hoặc mật khẩu!!!");
        }
    }

    public String mail() {
        String mail = "";
        while (true) {
            System.out.println("--------Nhập vào mail: ...@gmail...------");
            mail = scanner.nextLine();
            Pattern m = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,5}(\\.[a-zA-Z]+){1,3}$");
            if (m.matcher(mail).find()) {
                System.out.println("Mail: " + mail);
                break;
            } else {
                System.err.println("--------Nhập lại mail!!!-------");
            }
        }
        return mail;
    }

    public String password() {
        String pass = "";
        while (true) {
            System.out.println("-----Nhập vào pass: -----");
            pass = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,8}$");
            if (p.matcher(pass).find()) {
                System.out.println("------Hello my friend----");
                break;
            } else {
                System.out.println("----Nhập lại pass!!!");
            }
        }
        return pass;
    }
}
