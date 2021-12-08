package quanlykhachsan.controller;

import quanlykhachsan.menuRun.Main;
import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;
import quanlykhachsan.manage.ManageRoom;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RoomView {
    Scanner scanner = new Scanner(System.in);
    ManageRoom manageRoom = new ManageRoom();
    List<Room> roomList = manageRoom.findAll();


    public RoomView() throws IOException {
    }

    public void showRoom() throws IOException {
        for (Room r: roomList) {
            System.out.println(r);
        }
        System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void showRoomForUser() throws IOException {
        System.out.println("----Danh sách phòng còn trống: ----");
        for (Room b: roomList) {
            if (b.isStatus()) {
                System.out.println(b);
            }
        }
        System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            Main.bookRoom();
        }
    }



    public void addNewRoom() throws IOException {
        while (true) {
            for (Room r: roomList) {
                System.out.println(r);
            }
            int id;
            if (roomList.size() == 0) {
                id = 1;
            } else {
                id = roomList.get(roomList.size() - 1).getId() + 1;
            }
            Room room = getRoom(id);
            manageRoom.save(room);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    private Room getRoom(int id) throws IOException {
        System.out.println("Enter the name: ");
        String name = name();
        double price = checkPrice();
        return new Room(id, name, price);
    }

    public void editRoom() throws IOException {
        while (true) {
            for (Room r: roomList) {
                System.out.println(r);
            }
            int id = checkId();
            Room room = getRoom(id);
            manageRoom.edit(id,room);
            System.out.println("----Edit success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void deleteRoom() throws IOException {
        while (true) {
            for (Room r: roomList) {
                System.out.println(r);
            }
            int id = checkId();
            manageRoom.delete(id);
            System.out.println("----Delete success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }


    private double checkPrice() throws IOException {
        boolean checkPrice;
        double price = 0;
        do {
            System.out.println("Enter the price: ");
            checkPrice = true;
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkPrice = false;
                System.err.println("Giá phòng phải là số : VD : 1000.0 !!!");
                checkQuitOfRoom();
            }
        }while (!checkPrice);
        return price;
    }

    private int checkId() throws IOException {
        boolean checkId;
        int id = 0;
        do {
            System.out.println("----Nhập id muốn chọn: ----");
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

    public void sumMoney() throws IOException {
        BillView billView = new BillView();
        for (Bill b : billView.billList) {
            if (!b.isStatus()) {
                System.out.println(b);
            }
            ReadAndWrite<Bill> readAndWrite = new ReadAndWrite<>();
            Bill bill = new Bill();
            System.out.println("----Thanh toán----");
            boolean checkStatus = false;
            while (true) {
                System.out.println("Nhập id Bill thanh toán: ");
                int idBill = checkId();
                System.out.println("Nhập id Room thanh toán: ");
                int idRoom = checkId();
                System.out.println("\n-------------------------------------");
                System.out.println("Bạn muốn thanh toán phải không?");
                System.out.println("1. Thanh toán");
                System.out.println("2. Trở về");
                int moneySubChoice = Integer.parseInt(scanner.nextLine());
                System.out.println("-------------------------------------");
                if (moneySubChoice == 1) {
                    for (Room room : roomList) {
                        if (!room.isStatus())
                            if (room.getId() == idRoom) {
                                int money = 0;
                                money += (room.getPrice() * billView.findBillPrice(idBill) + billView.findBillPriceService(idBill));
                                checkStatus = true;
                                room.setStatus(true);
                                System.out.println("* Đã thanh toán: " + money + " VNĐ");
                                bill = billView.billList.get(idBill);
                                bill.setSumMoney(money);
                                billView.resetBill(idBill);
                                billView.billList.set(idBill, bill);
                                readAndWrite.writeToFile("C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\Bill.txt", billView.billList);
                                break;
                            }
                    }
                    if (checkStatus) {
                        System.out.println("----Thanh toán thành công! Cảm ơn quý khách ! ----");
                        Main.bookRoom();
                        break;
                    } else
                        System.err.println("Thanh toán thất bại! Mời nhập lại");
                } else if (moneySubChoice == 2) {
                    break;
                } else {
                    System.err.println("Không có thao tác này. Mời nhập lại");
                }
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
                checkQuitOfRoom();
            }
        }
        return name;
    }

    public void searchCheapRoom() {
        System.out.println("-------Phòng giá rẻ-------");
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPrice() >= 0 && roomList.get(i).getPrice() <= 100000 ) {
                System.out.println(roomList.get(i));
            }
        }
    }

    public void searchExpensiveRoom() {
        System.out.println("------Phòng giá cao------");
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPrice() > 100000) {
                System.out.println(roomList.get(i));
            }
        }
    }
    public void checkQuitOfRoom() throws IOException {
        System.err.println("-----Nhập lại !!! Or Enter QUIT to back MENU Quản lý---- ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

}
