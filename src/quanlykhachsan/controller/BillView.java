package quanlykhachsan.controller;

import quanlykhachsan.manage.ManageService;
import quanlykhachsan.menuRun.Login;
import quanlykhachsan.menuRun.Main;
import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;
import quanlykhachsan.manage.ManageBill;
import quanlykhachsan.manage.ManageRoom;
import quanlykhachsan.model.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BillView {
    Scanner scanner = new Scanner(System.in);
    ManageBill manageBill = new ManageBill();
    ManageRoom manageRoom = new ManageRoom();
    List<Bill> billList = manageBill.findAll();

    public BillView() throws IOException {
    }

    public void showBill() throws IOException {
        for (Bill b: billList) {
            System.out.println(b);
        }
        System.out.println("Enter QUIT to back MENU: ");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void showBillForUser() throws IOException {
        System.out.println("---Danh sách bill có sẵn: ---");
        for (Bill b: billList) {
            if (b.isStatus()) {
                System.out.println(b);
            }
        }
        System.out.println("Enter QUIT to back MENU: ");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("quit")) {
            Main.bookRoom();
        }
    }

    public void showBillFalseForUser() throws IOException {
        System.out.println("---Danh sách bill đã được đặt: ---");
        for (Bill b: billList) {
            if (!b.isStatus()) {
                System.out.println(b);
            }
        }
        System.out.println("Enter QUIT to back MENU: ");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("quit")) {
            Main.bookRoom();
        }
    }

    public void addNewBill() throws IOException {
        while (true) {
            for (Bill b: billList) {
                System.out.println(b);
            }
            int id;
            if (billList.size() == 0) {
                id = 1;
            } else {
                id = billList.get(billList.size() - 1).getId() + 1;
            }
            Bill bill = getBill(id);
            manageBill.save(bill);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void addNewBillForUser() throws IOException {
        while (true) {
            System.out.println("---Danh sách bill có sẵn: ---");
            for (Bill b: billList) {
                if (b.isStatus()) {
                    System.out.println(b);
                }
            }
            int id;
            if (billList.size() == 0) {
                id = 1;
            } else {
                id = billList.get(billList.size() - 1).getId() + 1;
            }
            Bill bill = getBill(id);
            manageBill.save(bill);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.bookRoom();
            }
        }
    }

    private Bill getBill(int id) throws IOException {
        System.out.println("Enter the BillName: ");
        String billName = name();
        System.out.println("Enter the renterName: ");
        String renterName = name();
        System.out.println("Enter the tenantsName");
        String tenantsName = name();
        int numberOfRental = checkDay();
        int sumMoney = 0;
        return new Bill(id, billName, renterName, tenantsName, numberOfRental,sumMoney);
    }

    public void editBill() throws IOException {
        while (true) {
            for (Bill b: billList) {
                System.out.println(b);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id muốn tìm: ");
            int id = checkId();
            Bill bill = getBill(id);
            manageBill.edit(id, bill);
            System.out.println("----Edit success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void deleteBill() throws IOException {
        while (true) {
            for (Bill b: billList) {
                System.out.println(b);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập id muốn tìm: ");
            int id = checkId();
            manageBill.delete(id);
            System.out.println("----Delete success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void checkAndAddRoom() throws IOException {
        while (true) {
            RoomView roomView = new RoomView();
            System.out.println("---Danh sách phòng còn trống---");
            for (Room b: roomView.roomList) {
                if (b.isStatus()) {
                    System.out.println(b);
                } else {
                    System.out.println("---");
                }
            }
            System.out.println("--Danh sách bill sử dụng được---");
            for (Bill b: billList) {
                if (b.isStatus()) {
                    System.out.println(b);
                } else {
                    System.out.println("---");
                }
            }
            System.out.println("Nhập mã id room muốn chọn: ");
            int id = checkId();
            int index = manageRoom.findById(id);
            if (index == -1) {
                System.err.println("Không có room này!!");
            } else {
                manageBill.findAll();
                System.out.println("Nhập mã id bill muốn chọn: ");
                int idBill = checkId();
                Room room = manageRoom.findListById(index);
                int billIndex = manageBill.findById(idBill);
                manageBill.addRoomToBill(billIndex, room);
            }
            System.out.println();
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.bookRoom();
            }
        }
    }

    public void checkAndAddService() throws IOException {
        while (true) {
            for (Bill b: billList) {
                if (!b.isStatus()) {
                    System.out.println(b);
                }
            }
            ServiceView serviceView = new ServiceView();
            ManageService manageService = new ManageService();
            for (Service s: serviceView.serviceList) {
                if (serviceView.serviceList.size() < 1) {
                    System.out.println("----Hiện tại không có dịch vụ!!! Mong quá khách thông cảm! ----");
                } else {
                    System.out.println(s);
                }
            }
            System.out.println("---Nhập tên dịch vụ---");
            String nameService = name();
            int index = manageService.findByName(nameService);
            if (index == -1) {
                System.err.println("Không có dịch vụ này!!");
            } else {
                manageBill.findAll();
                int indexService = manageService.findByName(nameService);
                System.out.println("Nhập mã id chọn Bill: ");
                int billId = checkId();
                int billIndex = manageBill.findById(billId);
                billList.get(billIndex).getService().add(serviceView.serviceList.get(indexService));
            }
            System.out.println();
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.bookRoom();
            }
        }
    }

    private int checkDay() throws IOException {
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
                checkQuitOfBill();
            }
        } while (!checkNumberOfRental);
        return numberOfRental;
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
        } while (!checkId);
        return id;
    }

    public int findBillPrice(int id) {
        int money = 0;
        for (Bill bill : billList) {
            if (bill.getId() == id) {
                money = bill.getNumberOfRental();
            }
        }
        return money;
    }

    public int findBillPriceService(int id) throws IOException {
        ManageService manageService = new ManageService();
        List<Service> serviceList = manageService.findAll();
        int money = 0;
        for (Bill bill : billList) {
            if (bill.getId() == id) {
                if (bill.getService() != null) {
                    money = serviceList.get(id).getPriceService()*serviceList.get(id).getQuantity();
                }
                else {
                    money = 0;
                }
            }
        }
        return money;
    }

    public void resetBill(int id) {
        for (Bill bill : billList) {
            if (bill.getId() == id)
                bill.setRoom(null);
        }
    }

    public void sumMoney() throws IOException {
        while (true) {
            int sumMoney = 0;
            for (Bill b : billList) {
                sumMoney += b.getSumMoney();
            }
            System.out.println("                                                   ★★★Tổng doanh thu của khách sạn là : " + sumMoney + "VND★★★");
            System.out.println();
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.classBillManage();
            }
        }
    }

    public String name() throws IOException {
        String name = "";
        while (true) {
            name = scanner.nextLine();
            Pattern m = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (m.matcher(name).find()) {
                System.out.println("Name: " + name);
                break;
            } else {
                checkQuitOfBill();
            }
        }
        return name;
    }

    public void checkQuitOfBill() throws IOException {
        System.err.println("-----Nhập lại !!! Or Enter QUIT to back MENU Quản lý---- ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            Login.menu();
        }
    }
}
