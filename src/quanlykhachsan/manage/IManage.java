package quanlykhachsan.manage;

import java.io.IOException;
import java.util.List;

public interface IManage<T> {
    List<T> findAll() throws IOException;

    void save(T room) throws IOException;

    void edit(int id, T bill) throws IOException;

    void delete(int index) throws IOException;

}
