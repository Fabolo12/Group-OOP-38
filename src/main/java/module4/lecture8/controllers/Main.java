package module4.lecture8.controllers;

import module4.lecture8.controllers.beans.ClientBean;
import module4.lecture8.services.ClientService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        final ClientService instance = ClientService.getInstance();
        final ClientBean clientBean = new ClientBean();
        clientBean.setName("John Doe");
        clientBean.setAddress("123 Main St");
        clientBean.setAge(30);
        final UUID uuid = instance.create(clientBean);
        System.out.println("Created client with ID: " + uuid);
        instance.delete(uuid);
    }
}
