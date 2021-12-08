package quanlykhachsan.manage;

import quanlykhachsan.config.ReadAndWrite;
import quanlykhachsan.model.Service;

import java.io.IOException;
import java.util.List;

public class ManageService{
    public static String PATH_SERVICE = "C:\\Users\\a\\IdeaProjects\\CaseModul2\\src\\quanlykhachsan\\file\\Service.txt";
    static ReadAndWrite<Service> readAndWriteFile = new ReadAndWrite<>();
    static List<Service> services = readAndWriteFile.readFromFile(PATH_SERVICE);

    public List<Service> findAll() throws IOException {
        readAndWriteFile.writeToFile(PATH_SERVICE,services);
        return services;
    }

    public void save(Service service) throws IOException {
        services.add(service);
        readAndWriteFile.writeToFile(PATH_SERVICE,services);
    }

    public void edit(String name, Service service) throws IOException {
        int index = findByName(name);
        if (index != -1) {
            services.set(index, service);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_SERVICE,services);
    }

    public void delete(String name) throws IOException {
        int index = findByName(name);
        if (index != -1) {
            services.remove(index);
        } else {
            System.out.println("Không tồn tại mã này!");
        }
        readAndWriteFile.writeToFile(PATH_SERVICE,services);
    }

    public int findByName(String name) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getServiceName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
