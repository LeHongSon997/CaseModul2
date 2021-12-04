package quanlykhachsan.sevice;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManageUser implements IManage{
    public String PATH_ROOM = "C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\User.txt";
    ReadAndWrite<User> readAndWriteFile = new ReadAndWrite<>();
    List<User> users = readAndWriteFile.readFromFile(PATH_ROOM);

    @Override
    public List<User> findAll() throws IOException {
        readAndWriteFile.writeToFile(PATH_ROOM,users);
        return users;
    }

    @Override
    public void save(Object user) throws IOException {
        users.add((User) user);
        readAndWriteFile.writeToFile(PATH_ROOM,users);
    }

    @Override
    public void edit(int id, Object bill) throws IOException {
        users.set(id, (User) bill);
        readAndWriteFile.writeToFile(PATH_ROOM,users);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    public int findById() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập id muốn tìm: ");
        int id = s.nextInt();
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
