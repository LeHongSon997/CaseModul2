package quanlykhachsan.view;

import quanlykhachsan.Main;
import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.controller.BillController;
import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;
import quanlykhachsan.sevice.ManageBill;
import quanlykhachsan.sevice.ManageRoom;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BillView {
    Scanner scanner = new Scanner(System.in);
    ManageBill manageBill = new ManageBill();
    ManageRoom manageRoom = new ManageRoom();
    BillController billController = new BillController();
    List<Bill> billList = billController.showBill();

    public BillView() throws IOException {
    }

    public void showBill() throws IOException {
        System.out.println(billList);
        System.out.println("Enter QUIT to back MENU: ");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void addNewBill() throws IOException {
        while (true) {
            int id;
            if (billList.size() == 0) {
                id = 1;
            } else {
                id = billList.get(billList.size() - 1).getId() + 1;
            }
            Bill bill = getBill(id);
            billController.addBill(bill);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    private Bill getBill(int id) {
        System.out.println("Enter the BillName: ");
        String billName = scanner.next();
        System.out.println("Enter the renterName: ");
        String renterName = scanner.next();
        System.out.println("Enter the tenantsName");
        String tenantsName = scanner.next();
        int numberOfRental = checkDay();
        int sumMoney = checkMoney();
        return new Bill(id, billName, renterName, tenantsName, numberOfRental, sumMoney);
    }

    public void editBill() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id muốn tìm: ");
            int id = checkId();
            int index = manageBill.findById(id);
            Bill bill = getBill(index);
            billController.editBill(index, bill);
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void deleteBill() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id muốn tìm: ");
            int id = checkId();
            billController.deleteBill(manageBill.findById(id));
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void checkAndAddRoom() throws IOException {
        while (true) {
            ReadAndWrite<Bill> readAndWrite = new ReadAndWrite<>();
                System.out.println("Nhập mã id room muốn chọn: ");
                int id = checkId();
                int index = manageRoom.findById(id);
                if (index == -1) {
                    System.err.println("Không có room này!!");
                } else {
                    manageBill.findAll();
                    Room room = manageRoom.findListById(index);
                    System.out.println("Nhập mã id chọn Bill: ");
                    int billId = checkId();
                    int billIndex = manageBill.findById(billId);
                    if (room.isStatus()) {
                        room.setStatus(false);
                        manageBill.addRoomToBill(billIndex, room);
                    }
                    else {
                            System.err.println("Khách sạn đã hết phòng hoặc bạn đang tranh phòng người ta :)))");
                        }
                    readAndWrite.writeToFile("Bill.txt",billList);
                }
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.bookRoom();
            }
        }
    }

    private int checkDay() {
        boolean checkNumberOfRental;
        int numberOfRental = 0;
        do {
            System.out.println("Enter the numberOfRental");
            checkNumberOfRental = true;
            try {
                numberOfRental = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkNumberOfRental = false;
                System.err.println("Số ngày thuê phải là số!!!");
            }
        } while (!checkNumberOfRental);
        return numberOfRental;
    }

    private int checkMoney() {
        boolean checkMoney;
        int sumMoney = 0;
        do {
            System.out.println("Enter the sumMoney");
            checkMoney = true;
            try {
                sumMoney = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkMoney = false;
                System.err.println("Tiền nhập vào phải là số!!!");
            }
        }while (!checkMoney);
        return sumMoney;
    }

    private int checkId() {
        boolean checkId;
        int id = 0;
        do {
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
