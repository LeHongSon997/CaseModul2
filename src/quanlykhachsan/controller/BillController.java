package quanlykhachsan.controller;

import quanlykhachsan.model.Bill;
import quanlykhachsan.sevice.ManageBill;

import java.io.IOException;
import java.util.List;

public class BillController {
    ManageBill manageBill = new ManageBill();

    public List<Bill> showBill() throws IOException {
       return manageBill.findAll();
    }

    public void addBill(Bill b) throws IOException {
        manageBill.save(b);
    }

    public void editBill(int id, Bill bill) throws IOException {
        manageBill.edit(manageBill.findById(id), bill);
    }

    public void deleteBill(int id) {
        manageBill.delete(manageBill.findById(id));
    }
}
