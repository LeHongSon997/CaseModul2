package quanlykhachsan.sevice;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;

import java.io.IOException;
import java.util.List;

public class ManageBill implements IManage{
    static public String PATH_BILL = "C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\Bill.txt";
    static ReadAndWrite<Bill> readAndWriteFile = new ReadAndWrite<>();
    static List<Bill> billList = readAndWriteFile.readFromFile(PATH_BILL);
    static {
        billList.add(new Bill(1,"Affordable","Sơn","Vinh",10,100000));
        billList.add(new Bill(2,"V.I.P","Sơn","Vinh",10,1000000));
        billList.add(new Bill(3,"Couple","Sơn","Vinh",10,10000000));
    }

    @Override
    public List<Bill> findAll() throws IOException {
//        readAndWriteFile.writeToFile(PATH_BILL,billList);
//        for (Bill b: billList) {
//            System.out.println(b);
//        }
        return billList;
    }

    @Override
    public void save(Object room) throws IOException {
        billList.add((Bill) room);
        readAndWriteFile.writeToFile(PATH_BILL,billList);
    }

    @Override
    public void edit(int id, Object bill) throws IOException {
        billList.set(id, (Bill) bill);
        readAndWriteFile.writeToFile(PATH_BILL,billList);
    }

    @Override
    public void delete(int id) {
        billList.remove(id);
    }

    public int findById(int id) {
        for (int i = 0; i < billList.size(); i++) {
            if (id == billList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void addRoomToBill(int index, Room room) throws IOException {
        if (room.isStatus()) {
            room.setStatus(false);
            Bill bill = billList.get(index);
            bill.setRoom(room);
            billList.set(index, bill);
        }
        else {
                System.err.println("Khách sạn đã hết phòng hoặc bạn đang tranh phòng người ta :)))");
        }
            readAndWriteFile.writeToFile(PATH_BILL,billList);
    }
}
