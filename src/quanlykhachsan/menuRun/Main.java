package quanlykhachsan.menuRun;

import quanlykhachsan.controller.BillView;
import quanlykhachsan.controller.RoomView;
import quanlykhachsan.controller.ServiceView;
import quanlykhachsan.controller.UserView;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public Main() throws IOException {
        UserView userView = new UserView();
        System.out.println("                                                       ★----*★*Merry*★*-----MENU-----★*Christmas*★----★");
        System.out.println("                                                       ★              1. Quản lý phòng                  ★");
        System.out.println("                                                       ★              2. Quản lý đơn đặt phòng          ★");
        System.out.println("                                                       ★              3. Quản lý dịch vụ                ★");
        System.out.println("                                                       ★              4. Sửa tài khoản đăng nhập        ★");
        System.out.println("                                                       ★              5. Xóa tài khoản đăng nhập        ★");
        System.out.println("                                                       ★              6. Show tài khoản                 ★");
        System.out.println("                                                       ★              0. Về MENU đăng nhập              ★");
        System.out.println("                                                       ★________________________________________________★");
        System.out.println("                                                                       ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();
            if (choice >= 1 && choice <= 6) {
                switch (choice) {
                    case 1: {
                        classRoomManage();
                        break;
                    }
                    case 2: {
                        classBillManage();
                        break;
                    }
                    case 3: {
                        choiceService();
                        break;
                    }
                    case 4: {
                        userView.editUser();
                        break;
                    }
                    case 5: {
                        userView.deleteUser();
                        break;
                    }
                    case 6: {
                        userView.showUser();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("----Bạn vừa quay về menu đăng nhập----");
        Login.menu();
    }

    public static void classRoomManage() throws IOException {
        RoomView roomView = new RoomView();
        System.out.println("                                                ★---*★*Merry*★*----Menu phòng khách sạn----★*Christmas*★----★");
        System.out.println("                                                ★                 1. Hiển thị danh sách phòng                 ★");
        System.out.println("                                                ★                     2. Thêm phòng                           ★");
        System.out.println("                                                ★                     3. Xóa phòng                            ★");
        System.out.println("                                                ★                     4. Sửa phòng                            ★");
        System.out.println("                                                ★                     0. Quay về MENU quản lý                 ★");
        System.out.println("                                                ★_____________________________________________________________★");
        System.out.println("                                                                      ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1: {
                        roomView.showRoom();
                        break;
                    }
                    case 2: {
                        roomView.addNewRoom();
                        break;
                    }
                    case 3: {
                        roomView.deleteRoom();
                        break;
                    }
                    case 4: {
                        roomView.editRoom();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("-----Bạn vừa quay về MENU quản lý----");
        new Main();
    }

    public static void classBillManage() throws IOException {
        BillView billView = new BillView();
        System.out.println("                                                  ★---*★*Merry*★*----Menu đơn đặt phòng----★*Christmas*★----★");
        System.out.println("                                                  ★                 1. Hiển thị danh sách bill                ★");
        System.out.println("                                                  ★                     2. Thêm bill                          ★");
        System.out.println("                                                  ★                     3. Xóa bill                           ★");
        System.out.println("                                                  ★                     4. Sửa bill                           ★");
        System.out.println("                                                  ★                     5. Tổng doanh thu                     ★");
        System.out.println("                                                  ★                     0. Quay về MENU                       ★");
        System.out.println("                                                  ★___________________________________________________________★");
        System.out.println("                                                                       ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();
            if (choice >= 1 && choice <= 5) {
                switch (choice) {
                    case 1: {
                        billView.showBill();
                        break;
                    }
                    case 2: {
                        billView.addNewBill();
                        break;
                    }
                    case 3: {
                        billView.deleteBill();
                        break;
                    }
                    case 4: {
                        billView.editBill();
                        break;
                    }
                    case 5: {
                        billView.sumMoney();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("----Bạn vừa quay về MENU quản lý-----");
        new Main();
    }

    public static void bookRoom() throws IOException {
        BillView billView = new BillView();
        RoomView roomView = new RoomView();
        System.out.println("                                           ★-----*★*Merry*★*-------Menu đặt phòng cho khách hàng------★*Christmas*★-----★");
        System.out.println("                                           ★                     1. Danh sách bill trống có sẵn                           ★");
        System.out.println("                                           ★                     2. Danh sách bill đã đặt phòng                           ★");
        System.out.println("                                           ★                     3. Tìm phòng giá rẻ hoặc giá cao                         ★");
        System.out.println("                                           ★                     4. Tạo bill mới < Nếu bill không có bill phù hợp >       ★");
        System.out.println("                                           ★                     5. Đặt phòng                                             ★");
        System.out.println("                                           ★                     6. Thanh toán tiền phòng                                 ★");
        System.out.println("                                           ★                     7. Danh sách phòng còn trống                             ★");
        System.out.println("                                           ★                     8. Lựa chọn dịch vụ cho bạn                              ★");
        System.out.println("                                           ★                     0. Quay lại menu đăng nhập                               ★");
        System.out.println("                                           ★______________________________________________________________________________★");
        System.out.println("                                                                        ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();

            if (choice >= 1 && choice <= 8) {
                switch (choice) {
                    case 7: {
                        roomView.showRoomForUser();
                        break;
                    }
                    case 5: {
                        billView.checkAndAddRoom();
                        break;
                    }
                    case 6: {
                        roomView.sumMoney();
                        break;
                    }
                    case 1: {
                        billView.showBillForUser();
                        break;
                    }
                    case 2: {
                        billView.showBillFalseForUser();
                        break;
                    }
                    case 4: {
                        billView.addNewBillForUser();
                        break;
                    }
                    case 8: {
                        billView.checkAndAddService();
                        break;
                    }
                    case 3: {
                        choiceRoomOfPrice();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("-----Bạn vừa quay về MENU đăng nhập-----");
        Login.menu();
    }

    public static void choiceService() throws IOException {
        ServiceView serviceView = new ServiceView();
        System.out.println("                                                ★------*★*Merry*★*-------Menu dịch vụ------★*Christmas*★-----★");
        System.out.println("                                                ★                      1. Danh sách dịch vụ                    ★");
        System.out.println("                                                ★                      2. Thêm dịch vụ                         ★");
        System.out.println("                                                ★                      3. Hủy dịch vụ                          ★");
        System.out.println("                                                ★                      4. Sửa dịch vụ                          ★");
        System.out.println("                                                ★                      0. Quay lại menu khách hàng             ★");
        System.out.println("                                                ★______________________________________________________________★");
        System.out.println("                                                                     ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();

            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1: {
                        serviceView.showService();
                        break;
                    }
                    case 2: {
                        serviceView.addNewService();
                        break;
                    }
                    case 3: {
                        serviceView.deleteService();
                        break;
                    }
                    case 4: {
                        serviceView.editService();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("-----Bạn vừa quay về MENU khách hàng-----");
        bookRoom();
    }

    public static void choiceRoomOfPrice() throws IOException {
        RoomView roomView = new RoomView();
        System.out.println("                                             ★------*★*Merry*★*-------Menu chọn phòng theo giá------★*Christmas*★-----★");
        System.out.println("                                             ★                            1. Phòng giá rẻ                               ★");
        System.out.println("                                             ★                            2. Phòng giá cao                              ★");
        System.out.println("                                             ★                       0. Quay lại menu khách hàng                        ★");
        System.out.println("                                             ★__________________________________________________________________________★");
        System.out.println("                                                                         ★★★Nhập lựa chọn★★★");
        int choice;
        do {
            choice = checkChoice();

            if (choice >= 1 && choice <= 2) {
                switch (choice) {
                    case 1: {
                        roomView.searchCheapRoom();
                        break;
                    }
                    case 2: {
                        roomView.searchExpensiveRoom();
                        break;
                    }
                }
            } else {
                System.err.println("---- Nhập lại lựa chọn !!! ----");
            }
        } while (choice != 0);
        System.err.println("-----Bạn vừa quay về MENU khách hàng-----");
        bookRoom();
    }

    private static int checkChoice() {
        Scanner scanner = new Scanner(System.in);
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
        } while (!checkChoice);
        return choice;
    }

    public static void main(String[] args) throws IOException {
        Login.menu();
    }
}
