package quanlykhachsan.model;

import java.io.Serializable;

public class Bill implements Serializable {
    private int id;
    private String billName;
    private String renterName;
    private String tenantsName;
    private int numberOfRental;
    private int sumMoney;
    private Room room;

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill(int id, String billName, String renterName, String tenantsName, int numberOfRental , int sumMoney) {
        this.id = id;
        this.billName = billName;
        this.renterName = renterName;
        this.tenantsName = tenantsName;
        this.numberOfRental = numberOfRental;
        this.sumMoney = sumMoney;
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

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billName='" + billName + '\'' +
                ", renterName='" + renterName + '\'' +
                ", tenantsName='" + tenantsName + '\'' +
                ", numberOfRental=" + numberOfRental +
                ", sumMoney=" + sumMoney +
                ", room : " + room
                ;
    }
}
