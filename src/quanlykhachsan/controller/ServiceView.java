package quanlykhachsan.controller;

import quanlykhachsan.manage.ManageService;
import quanlykhachsan.menuRun.Main;
import quanlykhachsan.model.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ServiceView{
    Scanner scanner = new Scanner(System.in);
    ManageService manageService = new ManageService();
    List<Service> serviceList = manageService.findAll();

    public ServiceView() throws IOException {
    }

    public void showService() throws IOException {
        for (Service s: serviceList) {
            System.out.println(s);
        }
        System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            Main.choiceService();
        }
    }

    public void addNewService() throws IOException {
        while (true) {
            for (Service s: serviceList) {
                System.out.println(s);
            }
            String name = name();
            Service service = getService(name);
            manageService.save(service);
            System.out.println("Add success");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.choiceService();
            }
        }
    }

    public void editService() throws IOException {
        while (true) {
            for (Service s: serviceList) {
                System.out.println(s);
            }
            System.out.println("---Nhập tên dịch vụ cần sửa: ---");
            String name = name();
            Service service = getService(name);
            System.out.println("---Nhập tên dịch vụ mới: ---");
            String name1 = name();
            manageService.edit(name1,service);
            System.out.println("----Edit success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
                Main.choiceService();
            }
        }
    }

    public void deleteService() throws IOException {
        while (true) {
            for (Service s: serviceList) {
                System.out.println(s);
            }
            String name = name();
            manageService.delete(name);
            System.out.println("----Delete success---");
            System.out.println("Enter any Key to continue - Enter QUIT to back MENU: ");
            String back = scanner.next();
            if (back.equalsIgnoreCase("quit")) {
             Main.choiceService();
            }
        }
    }

    private Service getService(String name) throws IOException {
        int price = checkPrice();
        int quantity = checkQuantity();
        return new Service(name, price,quantity);
    }

    public String name() throws IOException {
        String name = "";
        while (true) {
            System.out.println("Nhập vào tên dịch vụ: ");
            name = scanner.nextLine();
            Pattern m = Pattern.compile("^\\pL+[\\pL\\pZ\\pP ]{0,}$");
            if (m.matcher(name).find()) {
                System.out.println("Name: " + name);
                break;
            } else {
                checkQuit();
            }
        }
        return name;
    }

    private int checkPrice() throws IOException {
        boolean checkPrice;
        int price = 0;
        do {
            System.out.println("Enter the price: ");
            checkPrice = true;
            try {
                price = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkPrice = false;
                System.err.println("Giá dịch vụ phải là số : VD : 1000.0 !!!");
                checkQuit();
            }
        }while (!checkPrice);
        return price;
    }

    private int checkQuantity() throws IOException {
        boolean checkQuantity;
        int quantity = 0;
        do {
            System.out.println("Enter the quantity: ");
            checkQuantity = true;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                checkQuantity = false;
                System.err.println("Số lượng phải là số : !!!");
                checkQuit();
            }
        }while (!checkQuantity);
        return quantity;
    }

    public void checkQuit() throws IOException {
        System.err.println("-----Nhập lại !!! Or Enter QUIT to back MENU Dịch vụ---- ");
        String back = scanner.next();
        if (back.equalsIgnoreCase("quit")) {
            Main.choiceService();
        }
    }
}
