package org.example;

import org.example.entities.user.address.Geo;
import org.example.entities.user.address.Address;
import org.example.entities.user.Company;
import org.example.entities.user.User;
import org.example.services.CommentService;
import org.example.services.TaskService;
import org.example.services.UserService;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        // Creating object of user
        Geo geo = new Geo(-37.3159, 81.1496);
        Address address = new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", geo);
        Company company = new Company("Romaguera-Crona", "Multi-layered client-server neural-net",
                "harness real-time e-markets");

        User user = new User(4, "Leanne Graham", "Bret", "Sincere@april.biz",
                address, "1-770-736-8031 x56442", "hildegard.org", company);

        // UserService
        // System.out.println(UserService.createUser(user));
        // System.out.println(UserService.updateUser(user));
        // System.out.println(UserService.deleteUser(10));
        // System.out.println(UserService.getAllUsers());
        // System.out.println(UserService.getUserById(10));
        // System.out.println(UserService.getUserByUsername("Bret"));

        // Comment Service
        // System.out.println(CommentService.findLastPostComments(1));

        // Task Service
        // System.out.println(TaskService.getOpenTasks(1));
    }
}