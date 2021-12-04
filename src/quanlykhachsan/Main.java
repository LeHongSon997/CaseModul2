package quanlykhachsan;

import quanlykhachsan.Login;
import quanlykhachsan.view.BillView;
import quanlykhachsan.view.RoomView;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public Main() throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------MENU----------------");
            System.out.println("|        1. Quản lý phòng        |");
            System.out.println("|    2. Quản lý đơn đặt phòng    |");
            System.out.println("|        3. Back Login           |");
            System.out.println("|________________________________|");
            int choice;
            do {
                choice = scanner.nextInt();
                scanner.nextLine();
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
                        Login.menu();
                    }
                }

            } while (choice != 0);
    }

    public static void classRoomManage() throws IOException {
            Scanner scanner = new Scanner(System.in);
            RoomView roomView = new RoomView();
            System.out.println("--------------Menu phòng khách sạn-----------");
            System.out.println("|       1. Hiển thị danh sách phòng         |");
            System.out.println("|              2. Thêm phòng                |");
            System.out.println("|              3. Xóa phòng                 |");
            System.out.println("|              4. Sửa phòng                 |");
            System.out.println("|              0. Thoát                     |");
            System.out.println("|___________________________________________|");
            int choice;
            do {
                choice = scanner.nextInt();
                scanner.nextLine();
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
            } while (choice != 0);
        }

    public static void classBillManage() throws IOException {
            Scanner scanner = new Scanner(System.in);
            BillView billView = new BillView();

            System.out.println("---------------Menu đơn đặt phòng-------------");
            System.out.println("|          1. Hiển thị danh sách bill        |");
            System.out.println("|               2. Thêm bill                 |");
            System.out.println("|               3. Xóa bill                  |");
            System.out.println("|               4. Sửa bill                  |");
            System.out.println("|               0. Thoát                     |");
            System.out.println("|____________________________________________|");
            int choice;
            do {
                choice = scanner.nextInt();
                scanner.nextLine();
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
                }
            } while (choice != 0);
    }

    public static void bookRoom() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BillView billView = new BillView();
        RoomView roomView = new RoomView();
        while (true) {
        System.out.println("-------------Menu đặt phòng cho khách hàng------------");
        System.out.println("|              1. Hiển thị danh sách phòng           |");
        System.out.println("|              2. Đặt phòng                          |");
        System.out.println("|              3. Quay lại menu đăng nhập            |");
        System.out.println("|____________________________________________________|");
        int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    roomView.showRoomForUser();
                    break;
                }
                case 2: {
                    billView.checkAndAddRoom();
                    break;
                }
                case 3: {
                    Login.menu();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Login.menu();
    }
}
