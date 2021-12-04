package quanlykhachsan.controller;

import quanlykhachsan.model.User;
import quanlykhachsan.sevice.ManageUser;

import java.io.IOException;
import java.util.List;

public class UserController {
    ManageUser manageUser = new ManageUser();

    public List<User> showUser() throws IOException {
        return manageUser.findAll();
    }

    public void addUser(User user) throws IOException {
        manageUser.save(user);
    }

    public void editUser(int index, User user) throws IOException {
        manageUser.edit(manageUser.findById(), user);
    }

    public void deleteUser() {
        manageUser.delete(manageUser.findById());
    }

}
