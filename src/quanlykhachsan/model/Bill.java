package quanlykhachsan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private int id;
    private String billName;
    private String renterName;
    private String tenantsName;
    private int numberOfRental;
    private int sumMoney = 0;
    private boolean status = true;
    private Room room;
    private List<Service> service = new ArrayList<>();

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill(int id, String billName, String renterName, String tenantsName, int numberOfRental,int sumMoney) {
        this.id = id;
        this.billName = billName;
        this.renterName = renterName;
        this.tenantsName = tenantsName;
        this.numberOfRental = numberOfRental;
        this.sumMoney = sumMoney;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getTenantsName() {
        return tenantsName;
    }

    public void setTenantsName(String tenantsName) {
        this.tenantsName = tenantsName;
    }

    public int getNumberOfRental() {
        return numberOfRental;
    }

    public void setNumberOfRental(int numberOfRental) {
        this.numberOfRental = numberOfRental;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billName='" + billName + '\'' +
                ", renterName='" + renterName + '\'' +
                ", tenantsName='" + tenantsName + '\'' +
                ", numberOfRental=" + numberOfRental +
                ", sumMoney=" + sumMoney +
                ", status=" + status +
                ", room : " + room +
                ", service : " + service
                ;
    }
}
