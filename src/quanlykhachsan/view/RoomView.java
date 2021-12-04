package quanlykhachsan.view;

import quanlykhachsan.Main;
import quanlykhachsan.controller.RoomController;
import quanlykhachsan.model.Room;
import quanlykhachsan.sevice.ManageRoom;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomView {
    Scanner scanner = new Scanner(System.in);
    ManageRoom manageRoom = new ManageRoom();
    RoomController roomController = new RoomController();
    List<Room> roomList = roomController.showRoom();

    public RoomView() throws IOException {
    }

    public void showRoom() throws IOException {
        System.out.println(roomList);
        System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void showRoomForUser() throws IOException {
        System.out.println(roomList);
        System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            Main.bookRoom();
        }
    }

    public void addNewRoom() throws IOException {
        while (true) {
            int id;
            if (roomList.size() == 0) {
                id = 1;
            } else {
                id = roomList.get(roomList.size() - 1).getId() + 1;
            }
            Room room = getRoom(id);
            roomController.addRoom(room);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    private Room getRoom(int id) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        double price = checkPrice();
        return new Room(id, name, price);
    }

    public void editRoom() throws IOException {
        while (true) {
            int id = checkId();
            int index = manageRoom.findById(id);
            Room room = getRoom(index);
            roomController.editRoom(index,room);
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void deleteRoom() throws IOException {
        while (true) {
            int id = checkId();
            roomController.deleteBill(manageRoom.findById(id));
            System.out.println("Enter any Key to continue create - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }


    private double checkPrice() {
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
            }
        }while (!checkPrice);
        return price;
    }

    private int checkId() {
        boolean checkId;
        int id = 0;
        do {
            System.out.println("Nhập id muốn tìm: ");
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
