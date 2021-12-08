package quanlykhachsan.model;

import java.io.Serializable;

public class Service implements Serializable {
    private String serviceName;
    private int priceService;
    private int quantity;

    public Service() {
    }

    public Service(String serviceName, int priceService,int quantity) {
        this.serviceName = serviceName;
        this.priceService = priceService;
        this.quantity = quantity;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", priceService=" + priceService +
                ", quantity=" + quantity +
                '}';
    }
}
