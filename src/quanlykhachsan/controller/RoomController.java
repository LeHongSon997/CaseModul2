package quanlykhachsan.controller;

import quanlykhachsan.model.Bill;
import quanlykhachsan.model.Room;
import quanlykhachsan.sevice.ManageRoom;

import java.io.IOException;
import java.util.List;

public class RoomController {
    ManageRoom manageRoom = new ManageRoom();

    public List<Room> showRoom() throws IOException {
       return manageRoom.findAll();
    }

    public void addRoom(Room room) throws IOException {
        manageRoom.save(room);
    }

    public void editRoom(int id, Room room) throws IOException {
        manageRoom.edit(manageRoom.findById(id),room );
    }

    public void deleteBill(int id) {
        manageRoom.delete(manageRoom.findById(id));
    }
}
