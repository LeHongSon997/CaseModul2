package quanlykhachsan.manage;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;

import java.io.IOException;
import java.util.List;

public class ManageBill implements IManage{
    static public String PATH_BILL = "C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\Bill.txt";
    static ReadAndWrite<Bill> readAndWriteFile = new ReadAndWrite<>();
    static List<Bill> billList = readAndWriteFile.readFromFile(PATH_BILL);
//    static {
//        billList.add(new Bill(1,"Affordable","Sơn","Vinh",10,0));
//        billList.add(new Bill(2,"V.I.P","Sơn","Vinh",10,0));
//        billList.add(new Bill(3,"Couple","Sơn","Vinh",10,0));
//    }

    @Override
    public List<Bill> findAll() throws IOException {
        readAndWriteFile.writeToFile(PATH_BILL,billList);
        return billList;
    }

    @Override
    public void save(Object room) throws IOException {
        billList.add((Bill) room);
        readAndWriteFile.writeToFile(PATH_BILL,billList);
    }

    @Override
    public void edit(int id, Object bill) throws IOException {
        int index = findById(id);
        if (index != -1) {
            billList.set(index, (Bill) bill);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_BILL,billList);
    }

    @Override
    public void delete(int id) throws IOException {
        int index = findById(id);
        if (index != -1) {
            billList.remove(index);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_BILL,billList);
    }

    public int findById(int id) {
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void addRoomToBill(int index, Room room) throws IOException {
        Bill bill = new Bill();
        if (room.isStatus() && bill.isStatus()) {
            room.setStatus(false);
            bill = billList.get(index);
            bill.setRoom(room);
            bill.setStatus(false);
            billList.set(index, bill);
            System.out.println("-----Đặt phòng thành công-----");
        }
        else {
                System.err.println("----Khách sạn đã hết phòng hoặc bạn đang dùng bill cũ----");
        }
            readAndWriteFile.writeToFile(PATH_BILL,billList);
    }
}
