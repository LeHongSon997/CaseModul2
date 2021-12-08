package quanlykhachsan.manage;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.Room;

import java.io.IOException;
import java.util.List;

public class ManageRoom implements IManage{
    public static String PATH_ROOM = "C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\Room.txt";
    static ReadAndWrite<Room> readAndWriteFile = new ReadAndWrite<>();
    static List<Room> roomList = readAndWriteFile.readFromFile(PATH_ROOM);
//    static {
//        roomList.add(new Room(1,"Affordable",100000));
//        roomList.add(new Room(2,"V.I.P",1000000));
//        roomList.add(new Room(3,"Couple",10000000));
//    }


    @Override
    public List<Room> findAll() throws IOException {
        readAndWriteFile.writeToFile(PATH_ROOM,roomList);
        return roomList;
    }

    @Override
    public void save(Object room) throws IOException {
        roomList.add((Room) room);
        readAndWriteFile.writeToFile(PATH_ROOM,roomList);
    }

    @Override
    public void edit(int id, Object room) throws IOException {
        int index = findById(id);
        if (index != -1) {
            roomList.set(index, (Room) room);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_ROOM,roomList);
    }

    @Override
    public void delete(int id) throws IOException {
        int index = findById(id);
        if (index != -1) {
            roomList.remove(index);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_ROOM,roomList);
    }

    public int findById(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                 return i;
            }
        }
        return -1;
    }

    public Room findListById(int id) {
        return roomList.get(id);
    }
}
