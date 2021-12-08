package quanlykhachsan.manage;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.User;

import java.io.IOException;
import java.util.List;

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
    public void edit(int id, Object user) throws IOException {
        int index = findById(id);
        if (index != -1) {
            users.set(index, (User) user);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_ROOM,users);
    }

    @Override
    public void delete(int id) throws IOException {
        int index = findById(id);
        if (index != -1) {
            users.remove(index);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_ROOM,users);
    }

    public int findById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
